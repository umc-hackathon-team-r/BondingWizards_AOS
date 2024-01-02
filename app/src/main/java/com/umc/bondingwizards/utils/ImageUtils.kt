package com.naze.common.utils

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.webkit.MimeTypeMap
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream

/**
 * name => MultipartBody key name
 */
fun imageForUpload(context: Context, uri: Uri, name: String): MultipartBody.Part {
    val maxFileSizeKB = 4096

    val filePath = getRealPathFromUri(context, uri)
    val imageFile = filePath?.let { it1 -> File(it1) }

    val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
    val quality = if ((maxFileSizeKB * 100) / (bitmap.byteCount / 1024) >= 100) 100 else (maxFileSizeKB * 100) / (bitmap.byteCount / 1024)

    val compressedFile = File(context.cacheDir, imageFile?.name.toString())
    val outputStream = FileOutputStream(compressedFile)
    bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
    outputStream.flush()
    outputStream.close()

    val requestFile: RequestBody = compressedFile.asRequestBody("multipart/form-data".toMediaType())
    return MultipartBody.Part.createFormData(name, imageFile?.name, requestFile)
}

fun getRealPathFromUri(context: Context, uri: Uri): String? {
    var filePath: String? = null
    val contentResolver = context.contentResolver
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri, projection, null, null, null)

        cursor?.use {
            if (it.moveToFirst()) {
                val columnIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                filePath = it.getString(columnIndex)
            }
        }
    } else {
        contentResolver.openInputStream(uri)?.use { inputStream ->
            val extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(contentResolver.getType(uri))
            val fileName = "image_${System.currentTimeMillis()}.$extension"
            val file = File(context.cacheDir, fileName)
            FileOutputStream(file).use { outputStream ->
                inputStream.copyTo(outputStream)
            }
            filePath = file.absolutePath
        }
    }

    return filePath
}
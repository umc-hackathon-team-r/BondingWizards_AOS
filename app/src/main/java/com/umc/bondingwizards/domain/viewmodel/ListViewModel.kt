package com.umc.bondingwizards.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umc.bondingwizards.domain.type.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    //Repository Injection
): ViewModel() {

    private val _listState = MutableLiveData<ListItem>(ListItem.FRIEND)
    val listState: LiveData<ListItem> get() = _listState

    fun changeListState(item: ListItem) {
        _listState.value = item
    }

}
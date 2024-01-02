package com.umc.bondingwizards.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umc.bondingwizards.domain.model.Friend
import com.umc.bondingwizards.domain.model.Present
import com.umc.bondingwizards.domain.type.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    //Repository Injection
): ViewModel() {

    private val _listState = MutableLiveData<ListItem>(ListItem.FRIEND)
    val listState: LiveData<ListItem> get() = _listState

    private val _friendList = MutableLiveData<List<Friend>>()
    val friendList: LiveData<List<Friend>> get() = _friendList

    private val _presentList = MutableLiveData<List<Present>>()
    val presentList: LiveData<List<Present>> get() = _presentList

    fun changeListState(item: ListItem) {
        _listState.value = item
    }

    fun exampleFriendList() {
        val list = mutableListOf<Friend>()
        list.add(Friend(1,"김지송","2000-12-26"))
        list.add(Friend(2,"김지송2",))
        _friendList.value = list
    }

    fun examplePresentList() {
        val list = mutableListOf<Present>()
        list.add(Present())
        list.add(Present())
        _presentList.value = list
    }

}
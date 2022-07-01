package com.dom.nbaplayers.screens.playerInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dom.nbaplayers.data.repository.Repository
import com.dom.nbaplayers.model.allPlayers.AllPlayers
import kotlinx.coroutines.launch
import retrofit2.Response

class PlayerInfoViewModel: ViewModel() {

    var repo = Repository()
    val myPlayerList: MutableLiveData<Response<AllPlayers>> = MutableLiveData()

    fun getPlayers() {
        viewModelScope.launch {
            myPlayerList.value = repo.getAllPlayers()
        }
    }

}
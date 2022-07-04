package br.com.zup.minhamusicafavorita.detalhesalbum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.minhamusicafavorita.model.Album

class DetalhesAlbumViewModel : ViewModel() {
    private var _response : MutableLiveData<Album> = MutableLiveData()
    val response : LiveData<Album> = _response

    fun loadAlbum(album: Album){
        _response.value = album
    }
}
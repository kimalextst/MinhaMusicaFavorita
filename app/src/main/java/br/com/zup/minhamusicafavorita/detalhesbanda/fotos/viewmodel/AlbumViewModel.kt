package br.com.zup.minhamusicafavorita.detalhesbanda.fotos.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.minhamusicafavorita.detalhesbanda.fotos.datasource.AlbumDataSource
import br.com.zup.minhamusicafavorita.detalhesbanda.fotos.repository.AlbumRepository
import br.com.zup.minhamusicafavorita.model.Album

class AlbumViewModel : ViewModel() {
    private val repository = AlbumRepository(AlbumDataSource())
    private val _response: MutableLiveData<List<Album>> = MutableLiveData()
    val response: LiveData<List<Album>> = _response

    fun getAlbuns(){
        try {
            _response.value = repository.getAlbuns()
        }catch (ex: Exception){
            Log.i("Error", "------> ${ex.message}")
        }
    }
}
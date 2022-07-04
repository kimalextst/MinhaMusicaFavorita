package br.com.zup.minhamusicafavorita.detalhesbanda.fotos.repository

import br.com.zup.minhamusicafavorita.detalhesbanda.fotos.datasource.AlbumDataSource
import br.com.zup.minhamusicafavorita.model.Album

class AlbumRepository(private val dataSource: AlbumDataSource) {
    fun getAlbuns(): MutableList<Album> {
        return dataSource.listaAlbuns
    }
}
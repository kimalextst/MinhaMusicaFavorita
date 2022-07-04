package br.com.zup.minhamusicafavorita.detalhesbanda.fotos.datasource

import br.com.zup.minhamusicafavorita.*
import br.com.zup.minhamusicafavorita.model.Album

class AlbumDataSource {
    val listaAlbuns = mutableListOf(
        Album(
            R.drawable.album_1_fallen,
            ALBUM_FALLEN,
            DESCRICAO_GENERICA,
        ),
        Album(
            R.drawable.album_2_tod,
            ALBUM_THE_OPEN_DOOR,
            DESCRICAO_GENERICA
        ),
        Album(
            R.drawable.album_3_evanescence,
            ALBUM_EVANESCENCE,
            DESCRICAO_GENERICA
        ),
        Album(
            R.drawable.album_4_synthesis,
            ALBUM_SYNTHESIS,
            DESCRICAO_GENERICA
        ),
        Album(
            R.drawable.album_5_tbt,
            ALBUM_THE_BITTER_TRUTH,
            DESCRICAO_GENERICA
        ),
        Album(
            R.drawable.album_6_abh,
            ALBUM_ANYWHERE_BUT_HOME,
            DESCRICAO_GENERICA
        )
    )
}
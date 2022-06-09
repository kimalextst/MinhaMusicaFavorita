package br.com.zup.minhamusicafavorita.model

import android.os.Parcelable
import br.com.zup.minhamusicafavorita.VALOR_GENERICO
import kotlinx.android.parcel.Parcelize

@Parcelize

class Album (
    private var imagem: Int,
    private var nome: String,
    private var detalhe: String,
    private var artista:String = VALOR_GENERICO,
    private var anoDeLancamento:String = VALOR_GENERICO,
    private var gravadora:String = VALOR_GENERICO,
    private var estudios:String = VALOR_GENERICO,
    private var formatos:String = VALOR_GENERICO,
    private var generos:String = VALOR_GENERICO
) : Parcelable {

    fun getImage() = this.imagem
    fun getNome() = this.nome
    fun getDetalhe() = this.detalhe
    fun getArtista() = this.artista
    fun getAnoDeLancamento() = this.anoDeLancamento
    fun getGravadora() = this.gravadora
    fun getEstudios() = this.estudios
    fun getFormatos() = this.formatos
    fun getGeneros() = this.generos
}
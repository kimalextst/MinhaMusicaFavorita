package br.com.zup.minhamusicafavorita.detalhesbanda.fotos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.minhamusicafavorita.databinding.AlbumItemBinding
import br.com.zup.minhamusicafavorita.model.Album

class AlbumAdapter (
    private var listaAlbuns: MutableList<Album>,
    private val clickAlbum: (album: Album) -> Unit
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = listaAlbuns[position]
        holder.adicionarInformacoesView(album)
        holder.binding.cvItemLista.setOnClickListener {
            clickAlbum(album)
        }
    }

    override fun getItemCount(): Int = listaAlbuns.size

    fun atualizarListaAlbum(novaLista: List<Album>) {
        if (listaAlbuns.size == 0) {
            listaAlbuns = novaLista.toMutableList()
        } else {
            listaAlbuns.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class AlbumViewHolder(val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun adicionarInformacoesView(album : Album) {
            binding.ivAlbum.setImageResource(album.getImage())
        }
    }
}
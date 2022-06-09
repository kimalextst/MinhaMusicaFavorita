package br.com.zup.minhamusicafavorita.detalhesbanda.fotos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.minhamusicafavorita.*
import br.com.zup.minhamusicafavorita.databinding.FragmentFotosBinding
import br.com.zup.minhamusicafavorita.detalhesalbum.DetalhesAlbumActivity
import br.com.zup.minhamusicafavorita.detalhesbanda.fotos.adapter.AlbumAdapter
import br.com.zup.minhamusicafavorita.model.Album

class FotosFragment : Fragment() {

    private lateinit var binding: FragmentFotosBinding

    private val adapter: AlbumAdapter by lazy {
        AlbumAdapter(arrayListOf(), this::irParaDetalhe)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exibirRecyclerView()
    }

    private fun exibirRecyclerView() {
        adicionarItemListaAlbuns()
        binding.rvAlbum.adapter = adapter
        val layoutManager = GridLayoutManager(requireContext(),2)
        binding.rvAlbum.layoutManager = layoutManager
    }

    private fun adicionarItemListaAlbuns() {
        val listaAlbuns = mutableListOf<Album>()

        listaAlbuns.add(
            Album(
                R.drawable.album_1_fallen,
                ALBUM_FALLEN,
                DESCRICAO_GENERICA,
            )
        )

        listaAlbuns.add(
            Album(
                R.drawable.album_2_tod,
                ALBUM_THE_OPEN_DOOR,
                DESCRICAO_GENERICA
            )
        )

        listaAlbuns.add(
            Album(
                R.drawable.album_3_evanescence,
                ALBUM_EVANESCENCE,
                DESCRICAO_GENERICA
            )
        )

        listaAlbuns.add(
            Album(
                R.drawable.album_4_synthesis,
                ALBUM_SYNTHESIS,
                DESCRICAO_GENERICA
            )
        )

        listaAlbuns.add(
            Album(
                R.drawable.album_5_tbt,
                ALBUM_THE_BITTER_TRUTH,
                DESCRICAO_GENERICA
            )
        )

        listaAlbuns.add(
            Album(
                R.drawable.album_6_abh,
                ALBUM_ANYWHERE_BUT_HOME,
                DESCRICAO_GENERICA
            )
        )

        adapter.atualizarListaAlbum(listaAlbuns)
    }

    private fun irParaDetalhe(album: Album) {
        val intent = Intent(requireContext(), DetalhesAlbumActivity::class.java).apply {
            putExtra(ALBUM_KEY, album)
        }
        startActivity(intent)
    }
}
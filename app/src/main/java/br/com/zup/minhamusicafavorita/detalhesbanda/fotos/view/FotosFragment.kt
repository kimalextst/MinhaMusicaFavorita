package br.com.zup.minhamusicafavorita.detalhesbanda.fotos.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.minhamusicafavorita.*
import br.com.zup.minhamusicafavorita.databinding.FragmentFotosBinding
import br.com.zup.minhamusicafavorita.detalhesalbum.view.DetalhesAlbumActivity
import br.com.zup.minhamusicafavorita.detalhesbanda.fotos.adapter.AlbumAdapter
import br.com.zup.minhamusicafavorita.detalhesbanda.fotos.viewmodel.AlbumViewModel
import br.com.zup.minhamusicafavorita.model.Album

class FotosFragment : Fragment() {

    private lateinit var binding: FragmentFotosBinding

    private val adapter: AlbumAdapter by lazy {
        AlbumAdapter(arrayListOf(), this::irParaDetalhe)
    }

    private val viewModel : AlbumViewModel by lazy {
        ViewModelProvider(this)[AlbumViewModel::class.java]
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

        viewModel.getAlbuns()
        observables()
        setUpRvAlbumList()
    }

    private fun observables(){
        viewModel.response.observe(this) {
            adapter.atualizarListaAlbum(it)
        }
    }

    private fun setUpRvAlbumList(){
        binding.rvAlbum.adapter = adapter
        val layoutManager = GridLayoutManager(requireContext(),2)
        binding.rvAlbum.layoutManager = layoutManager
    }

    private fun irParaDetalhe(album: Album) {
        val intent = Intent(requireContext(), DetalhesAlbumActivity::class.java).apply {
            putExtra(ALBUM_KEY, album)
        }
        startActivity(intent)
    }
}
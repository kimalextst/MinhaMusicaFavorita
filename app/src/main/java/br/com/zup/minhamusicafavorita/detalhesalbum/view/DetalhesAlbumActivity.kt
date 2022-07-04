package br.com.zup.minhamusicafavorita.detalhesalbum.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import br.com.zup.minhamusicafavorita.ALBUM_KEY
import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.databinding.ActivityDetalhesAlbumBinding
import br.com.zup.minhamusicafavorita.detalhesalbum.viewmodel.DetalhesAlbumViewModel
import br.com.zup.minhamusicafavorita.model.Album

class DetalhesAlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesAlbumBinding

    private val viewModel : DetalhesAlbumViewModel by lazy {
        ViewModelProvider(this)[DetalhesAlbumViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        observable()
        recuperarAlbum()
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.title_detalhe)
    }

    private fun recuperarAlbum(){
        val album = intent.getParcelableExtra<Album>(ALBUM_KEY)

        album?.let { viewModel.loadAlbum(it)}
    }

    private fun observable() {
        viewModel.response.observe(this) {
            binding.ivAlbumCover.setImageResource(it.getImage())
            binding.tvAlbumTittle.text = it.getNome()
            binding.tvAlbumDescription.text = it.getDetalhe()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

package br.com.zup.minhamusicafavorita.detalhesalbum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.com.zup.minhamusicafavorita.ALBUM_KEY
import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.databinding.ActivityDetalhesAlbumBinding
import br.com.zup.minhamusicafavorita.model.Album

class DetalhesAlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        recuperarAlbum()
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.title_detalhe)
    }

    private fun recuperarAlbum(){
        val album = intent.getParcelableExtra<Album>(ALBUM_KEY)

        if (album != null){
            exibirInformacoes(album)
            Toast.makeText(this,"Tá funfando: ${album.getNome()}", Toast.LENGTH_LONG).show()
        }
    }

    private fun exibirInformacoes(album: Album){
        binding.ivAlbumCover.setImageResource(album.getImage())
        binding.tvAlbumTittle.text = album.getNome()
        binding.tvAlbumDescription.text = album.getDetalhe()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
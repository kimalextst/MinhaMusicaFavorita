package br.com.zup.minhamusicafavorita.detalhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.getString
import android.provider.Settings.System.getString
import android.view.MenuItem
import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.databinding.ActivityDetalheBinding
import br.com.zup.minhamusicafavorita.detalhes.adapter.DetalhePagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetalheActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetalheBinding
    private val listaTitulos = listOf("Informações", "Fotos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirAppBarCustomizada()
        exibirViewPagerTabLayout()
    }

    private fun exibirViewPagerTabLayout() {
        val detalhePagerAdapter =
            DetalhePagerAdapter(supportFragmentManager, lifecycle, listaTitulos)
        binding.vpDetalhes.adapter = detalhePagerAdapter

        TabLayoutMediator(binding.tlDetalhes, binding.vpDetalhes) { tab, posicao ->
            tab.text = listaTitulos[posicao]
        }.attach()
    }

    private fun exibirAppBarCustomizada() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.title_detalhe)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
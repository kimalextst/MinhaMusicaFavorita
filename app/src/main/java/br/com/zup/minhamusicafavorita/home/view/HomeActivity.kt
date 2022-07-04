package br.com.zup.minhamusicafavorita.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.minhamusicafavorita.databinding.ActivityHomeBinding
import br.com.zup.minhamusicafavorita.detalhesbanda.view.DetalhesBandaActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bvIrParaDetalhes.setOnClickListener {
            startActivity(Intent(this, DetalhesBandaActivity::class.java))
        }
    }
}
package br.com.zup.minhamusicafavorita.detalhesbanda.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.minhamusicafavorita.detalhesbanda.fotos.FotosFragment
import br.com.zup.minhamusicafavorita.detalhesbanda.informacoes.InfoFragment


class DetalhePagerAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var listaTitulos: List<String>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = listaTitulos.size

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return InfoFragment()
            1 -> return FotosFragment()
        }

        return InfoFragment()
}
}
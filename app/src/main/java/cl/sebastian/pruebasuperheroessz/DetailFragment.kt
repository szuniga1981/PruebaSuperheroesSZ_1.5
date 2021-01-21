package cl.sebastian.pruebasuperheroessz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import cl.sebastian.pruebasuperheroessz.databinding.FragmentDetailBinding
import coil.load
import timber.log.Timber


class DetailFragment : Fragment(){
lateinit var  binding: FragmentDetailBinding
    private val viewModel:SuperHeroVM by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailBinding.inflate(layoutInflater)
viewModel.getDetail().observe(viewLifecycleOwner,{
            it?.let {
                binding.tvFullName.text=it.biography.fullName
                binding.tvHeroDetail.text=it.name
               // binding.tvPublisher.text=it.biography.alignment
                binding.ivDetail.load(it.images.lg)
                binding.tvInteligencia.text=it.powerstats.intelligence.toString()
                binding.tvCombate.text=it.powerstats.combat.toString()
                binding.tvDurabilidad.text=it.powerstats.durability.toString()
                binding.tvPoder.text=it.powerstats.power.toString()
                binding.tvVelocidad.text=it.powerstats.speed.toString()
                binding.tvFuerza.text=it.powerstats.strength.toString()


}
})



        return binding.root
    }
}
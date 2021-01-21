package cl.sebastian.pruebasuperheroessz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.sebastian.pruebasuperheroessz.databinding.FragmentListingBinding

class ListingFragment : Fragment(){

    private lateinit var binding: FragmentListingBinding
    private val viewModel:SuperHeroVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListingBinding.inflate(layoutInflater)
        val adapter= HeroAdapter()
        binding.rvSuperhero.layoutManager=LinearLayoutManager(context)
        binding.rvSuperhero.adapter=adapter
        viewModel.superList.observe(viewLifecycleOwner,{
            it?.let {
                adapter.updateList(it)

            }
        })
        adapter.selectedHero().observe(viewLifecycleOwner,{
            viewModel.setSelected(it)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container,DetailFragment())
                ?.addToBackStack("details")
                ?.commit()
        })

        return binding.root
    }


}
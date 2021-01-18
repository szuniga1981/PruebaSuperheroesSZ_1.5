package cl.sebastian.pruebasuperheroessz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.sebastian.pruebasuperheroessz.databinding.ItemListShBinding
import coil.api.load

class HeroAdapter: RecyclerView.Adapter<HeroesVH>() {
    var heroesList= listOf<Heroes>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesVH {
        val binding=ItemListShBinding.inflate(LayoutInflater.from(parent.context))
        return HeroesVH(binding)
    }

    override fun onBindViewHolder(holder: HeroesVH, position: Int) {
       val heroes=heroesList[position]
        holder.bind(heroes)
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    fun updateList(lista: List<Heroes>) {
        heroesList=lista
        notifyDataSetChanged()

    }

}

class HeroesVH(val binding: ItemListShBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(heroes: Heroes) {
        binding.tvHero.text=heroes.name
        binding.ivHero.load(heroes.images.lg)

    }

}

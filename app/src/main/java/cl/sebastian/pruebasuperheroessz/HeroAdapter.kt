package cl.sebastian.pruebasuperheroessz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.sebastian.pruebasuperheroessz.databinding.ItemListShBinding

import coil.load
import timber.log.Timber

class HeroAdapter: RecyclerView.Adapter<HeroesVH>() {
   private var heroesList= listOf<Heroes>()
    private val selectedHero= MutableLiveData<Heroes>()
    fun selectedHero():LiveData<Heroes> = selectedHero


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesVH {
        val binding=ItemListShBinding.inflate(LayoutInflater.from(parent.context))
        return HeroesVH(binding)
    }

    override fun onBindViewHolder(holder: HeroesVH, position: Int) {
       val heroes=heroesList[position]
        holder.bind(heroes)
        holder.itemView.setOnClickListener{
            Timber.d("mostrando DetailFragment")
            selectedHero.value=heroes
        }
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    fun updateList(lista: List<Heroes>) {
        heroesList=lista
        notifyDataSetChanged()

    }

}

class HeroesVH(val binding:ItemListShBinding ):RecyclerView.ViewHolder(binding.root) {
    fun bind(heroes: Heroes) {
        binding.tvHero.text=heroes.name
        binding.ivHero.load(heroes.images.lg)


    }

}

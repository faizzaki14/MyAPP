package com.faizzakiramadhan_19104075.myapplication

import com.faizzakiramadhan_19104075.myapplication.Food
import androidx.recyclerview.widget.RecyclerView
import com.faizzakiramadhan_19104075.myapplication.FoodLocationAdapter.FoodLocationViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.faizzakiramadhan_19104075.myapplication.R
import com.flaviofaria.kenburnsview.KenBurnsView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.lang.String

class FoodLocationAdapter(private val foodlocation: List<Food>) :
    RecyclerView.Adapter<FoodLocationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodLocationViewHolder {
        return FoodLocationViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodLocationViewHolder, position: Int) {
        holder.setLocationData(foodlocation[position])
    }

    override fun getItemCount(): Int {
        return foodlocation.size
    }

    class FoodLocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val kbv_location: KenBurnsView
        private val text_title: TextView
        private val text_location: TextView
        private val text_starRating: TextView
        fun setLocationData(food: Food) {
            Picasso.get().load(food.imageUrl).into(kbv_location)
            text_title.text = food.title
            text_location.text = food.harga
            text_starRating.text = String.valueOf(food.starRating)
        }

        init {
            kbv_location = itemView.findViewById(R.id.kbv_location)
            text_title = itemView.findViewById(R.id.text_title)
            text_location = itemView.findViewById(R.id.text_location)
            text_starRating = itemView.findViewById(R.id.text_starRating)
        }
    }
}
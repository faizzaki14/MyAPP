package com.faizzakiramadhan_19104075.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodLocationAdapter extends RecyclerView.Adapter<FoodLocationAdapter.FoodLocationViewHolder> {

    private List<Food> foodlocation;

    public FoodLocationAdapter(List<Food> foodlocation) {
        this.foodlocation = foodlocation;
    }

    @NonNull
    @Override
    public FoodLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.card_item,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FoodLocationViewHolder holder, int position) {

        holder.setLocationData(foodlocation.get(position));

    }

    @Override
    public int getItemCount() {
        return foodlocation.size();
    }

    static class FoodLocationViewHolder extends RecyclerView.ViewHolder{

        private KenBurnsView kbv_location;
        private TextView text_title, text_location, text_starRating;


        FoodLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kbv_location = itemView.findViewById(R.id.kbv_location);
            text_title = itemView.findViewById(R.id.text_title);
            text_location = itemView.findViewById(R.id.text_location);
            text_starRating = itemView.findViewById(R.id.text_starRating);
        }

        void setLocationData(Food food){
            Picasso.get().load(food.imageUrl).into(kbv_location);
            text_title.setText(food.title);
            text_location.setText(food.harga);
            text_starRating.setText(String.valueOf(food.starRating));
        }

    }
}

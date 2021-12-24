package com.faizzakiramadhan_19104075.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;

public class foodAdapterViewHolder extends RecyclerView.ViewHolder {

    private KenBurnsView kbv_location;
    private TextView title, harga;

    foodAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}

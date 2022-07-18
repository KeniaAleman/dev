package com.company.informationbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.CardViewHolder> {

    private ArrayList<ModelClass> modelList;
    private Context context; // will be able to show the category pics on the screen by clicking on categories

    public AdapterClass(ArrayList<ModelClass> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) { // shows the data on the screen
        ModelClass model = modelList.get(position);
        holder.tvs.setText(model.getCategoryName());
        holder.ivs.setImageResource(context.getResources().getIdentifier(model.getCategoryImage(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    //inner class
    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivs;
        private TextView tvs;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            //define components
            ivs = itemView.findViewById(R.id.imageViewSplash);
            tvs = itemView.findViewById(R.id.textViewSplash);
        }
    }
}

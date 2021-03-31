package com.example.recycleview.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.model.Cat;

import java.util.List;

public class CatRcvAdapter extends RecyclerView.Adapter<CatRcvAdapter.CatHolder> {
    private List<Cat> cats;
    private Activity activity;
    private CatRcvAdapter t;
    public CatRcvAdapter(Activity activity, List<Cat> list){
        cats = list;
        this.activity = activity;

    }
    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = activity.getLayoutInflater().inflate(R.layout.cat_card_item,parent,false);
        return new CatHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        t=this;
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cats.remove(position);
                t.notifyDataSetChanged();

            }
        });
        Cat cat = cats.get(position);
        holder.img.setImageResource(cat.getRsImg());
        holder.name.setText(cat.getName());
        holder.weight.setText(""+cat.getWeight()+" kg");

    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class CatHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name, weight;
        private Button btnRemove;
        public CatHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            weight = itemView.findViewById(R.id.weight);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}

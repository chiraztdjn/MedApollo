package com.example.medapollo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.MyHolder> {
    Context context;
    ArrayList<Medclass>arrayList;
    LayoutInflater layoutInflater;

    public MedAdapter(Context context, ArrayList<Medclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.item_file,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.medName.setText(arrayList.get(position).getMedName());
        holder.img.setImageResource(arrayList.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

      TextView medName;
      ImageView img;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            medName=itemView.findViewById(R.id.txt);
            img=itemView.findViewById(R.id.img);
        }
    }
}

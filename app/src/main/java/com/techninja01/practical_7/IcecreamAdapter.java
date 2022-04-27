package com.techninja01.practical_7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IcecreamAdapter extends RecyclerView.Adapter<IcecreamAdapter.viewHolder> {

    ArrayList<IcecreamList> list;
    Context context;

    public IcecreamAdapter(ArrayList<IcecreamList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.customlist,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        IcecreamList model = list.get(position);
        holder.pic.setImageResource(model.getImages());
        holder.name.setText(model.getNames());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Selected "+model.getNames(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView pic;
        TextView name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView);
        }
    }
}

package com.example.appdev_assignment5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    private ArrayList<String> message;
    private ArrayList<String> names;
    private ArrayList<String> times;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;
    public int name_index = 0;

    RecyclerviewAdapter(Context context, ArrayList<String> message, ArrayList<String> names, ArrayList<String> times) {
        this.layoutInflater = LayoutInflater.from(context);
        this.message = message;
        this.names=names;
        this.times=times;
        //name_index=names.size()-1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view;

        if(names.get(name_index).equals("ICH")){
            view = layoutInflater.inflate(R.layout.textfield2, viewGroup, false);
        }
        else {
            view = layoutInflater.inflate(R.layout.textfield, viewGroup, false);
        }
        name_index++;

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        String msg = message.get(position);
        viewHolder.message.setText(msg);
        String name = names.get(position);
        viewHolder.name.setText(name);
        String time = times.get(position);
        viewHolder.time.setText(time);



    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView message;
        TextView name;
        TextView time;

        ViewHolder(View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.textView2);
            name = itemView.findViewById(R.id.textView);
            time = itemView.findViewById(R.id.textView1);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    String getItem(int id) {
        return message.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
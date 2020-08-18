package com.xiawenhao.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {
    public MyAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    private List<Data> dataList;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(itemView);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.title.setText(data.getTitle());
        holder.count.setText(String.valueOf(data.getCount()));
        holder.description.setText(data.getDescription());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView count;
        public TextView description;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            count = itemView.findViewById(R.id.count);
            description = itemView.findViewById(R.id.description);
        }
    }
}

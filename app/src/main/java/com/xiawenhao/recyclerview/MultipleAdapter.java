package com.xiawenhao.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MultipleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public MultipleAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    private List<Data> dataList;

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

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView header;

        public HeaderViewHolder(View view) {
            super(view);
            header = view.findViewById(R.id.header);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case Data.TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_line, parent, false);
                return new HeaderViewHolder(view);
            case Data.TYPE_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details, parent, false);
                return new ItemViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataList.get(position).type) {
            case 0:
                return Data.TYPE_ITEM;
            case 1:
                return Data.TYPE_HEADER;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        if (data != null) {
            switch (data.getType()) {
                case Data.TYPE_HEADER:
                    ((HeaderViewHolder) holder).header.setText(data.getTitle());
                    break;
                case Data.TYPE_ITEM:
                    ((ItemViewHolder) holder).title.setText(data.getTitle());
                    ((ItemViewHolder) holder).description.setText(data.getDescription());
                    ((ItemViewHolder) holder).count.setText(String.valueOf(data.getCount()));
                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

package com.xiawenhao.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Data> dataList;

    public ImageAdapter(Context mContext, List<Data> data) {
        this.mContext = mContext;
        this.dataList = data;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView count;
        TextView description;

        public ItemViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            title = view.findViewById(R.id.title);
            count = view.findViewById(R.id.count);
            description = view.findViewById(R.id.description);

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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list, parent, false);
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
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        if (data != null) {
            switch (data.type) {
                case Data.TYPE_HEADER:
                    ((HeaderViewHolder) holder).header.setText(data.getTitle());
                    break;
                case Data.TYPE_ITEM:
                    ((ItemViewHolder) holder).title.setText(data.getTitle());
                    ((ItemViewHolder) holder).count.setText(String.valueOf(data.getCount()));
                    ((ItemViewHolder) holder).description.setText(data.getDescription());
                    Glide.with(mContext).load(data.avatar).into(((ItemViewHolder) holder).image);
                    break;

            }

        }
    }
}
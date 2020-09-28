package com.example.aicarapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aicarapplication.R;
import com.example.aicarapplication.pojo.ContentBean;

import java.util.List;


public class ContentRecycleViewAdapter extends RecyclerView.Adapter<ContentRecycleViewAdapter.ViewHolder> {
    private List<ContentBean> contentBeans;

    public ContentRecycleViewAdapter(List<ContentBean> contentBeans) {
        this.contentBeans = contentBeans;
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(contentBeans.get(position).getItemName());
        holder.imageView.setImageResource(contentBeans.get(position).getItemImage());
        holder.content.setText(contentBeans.get(position).getItemContent());

    }

    @Override
    public int getItemCount() {
        return contentBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title,content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.content_image);
            title=itemView.findViewById(R.id.content_title);
            content=itemView.findViewById(R.id.content);

        }
    }
}

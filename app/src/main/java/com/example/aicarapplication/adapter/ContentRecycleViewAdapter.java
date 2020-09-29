package com.example.aicarapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aicarapplication.Activity.NewsActivity;
import com.example.aicarapplication.R;
import com.example.aicarapplication.pojo.ContentBean;
import com.example.aicarapplication.pojo.NewsBean;
import com.google.gson.Gson;

import java.util.List;


public class ContentRecycleViewAdapter extends RecyclerView.Adapter<ContentRecycleViewAdapter.ViewHolder> {
    private List<ContentBean> contentBeans;
    private List<NewsBean> newsBeans;
    private Context context;

    public ContentRecycleViewAdapter(Context context, List<ContentBean> contentBeans, List<NewsBean> newsBeans) {
        this.contentBeans = contentBeans;
        this.newsBeans=newsBeans;
        this.context=context;
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
        holder.content.setText(contentBeans.get(position).getItemContent().substring(0,40));
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Intent intent=new Intent(context,NewsActivity.class);
                intent.putExtra("data", new Gson().toJson(newsBeans.get(position)));
                context.startActivity(intent);
            }
        });

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

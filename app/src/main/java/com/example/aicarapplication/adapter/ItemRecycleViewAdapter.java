package com.example.aicarapplication.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aicarapplication.Activity.TeamActivity;
import com.example.aicarapplication.R;
import com.example.aicarapplication.pojo.ItemBean;

import java.util.List;

public class ItemRecycleViewAdapter extends  RecyclerView.Adapter<ItemRecycleViewAdapter.ViewHolder> {
    private List<ItemBean> itemBeanList;
    private Context context;
    public ItemRecycleViewAdapter(Context context, List<ItemBean> data) {
        this.context=context;
        itemBeanList = data ;
    }
    @NonNull
    @Override
    public ItemRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_item, parent, false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.imageView.setOnClickListener(v -> {
            int position=viewHolder.getLayoutPosition();
            Log.d("MainActivity", "onClick: "+position);
            ItemBean itemBean = itemBeanList.get(position);
                Toast.makeText(v.getContext(),itemBean.getItemName(),Toast.LENGTH_SHORT).show();


        });
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=viewHolder.getAdapterPosition();
                ItemBean itemBean = itemBeanList.get(position);
                switch (itemBean.getItemImage()){
                    case R.mipmap.team:
                        context.startActivity(new Intent(context, TeamActivity.class));
                        break;
                    case R.mipmap.join:
                        Uri uri=Uri.parse("https://github.com/1963077475/AICar");
                        Intent intent=new Intent();
                        intent.setData(uri);
                        context.startActivity(intent);
                        break;
                    case R.mipmap.info:
                        AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setTitle("敬请期待!");
                        builder.setMessage("敬请期待!");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();


                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecycleViewAdapter.ViewHolder holder, int position) {
        ItemBean itemBean = itemBeanList.get(position);
        holder.textView.setText(itemBean.getItemName());
        holder.imageView.setImageResource(itemBean.getItemImage());
        Log.d("MainActivity", "onBindViewHolder: "+itemBean.toString());

    }

    @Override
    public int getItemCount() {
        return itemBeanList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.item_text);
            imageView=itemView.findViewById(R.id.item_image);
        }
    }
}

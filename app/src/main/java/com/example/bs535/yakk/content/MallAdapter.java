package com.example.bs535.yakk.content;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bs535.yakk.MainActivity;
import com.example.bs535.yakk.R;


import java.util.List;

/**
 * Created by asus on 2017/8/12.
 */

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.ViewHolder>  {
    private Context mContext;
    private List<Mall> mMallList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView)view.findViewById(R.id.fruit_name);

        }
    }
    public MallAdapter(List<Mall> fruitList){
        mMallList = fruitList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item,parent,false);

        final ViewHolder holder = new ViewHolder(view) ;
        holder.cardView.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Mall mall = mMallList.get(position);
                if(mall.getName().equals("宝宝睡不好 难受")){
                    Intent intent = new Intent(mContext, MallActivity.class);
                    intent.putExtra(MallActivity.FRUIT_NAME, mall.getName());
                    intent.putExtra(MallActivity.FRUIT_IMAGE_ID, mall.getImageId());
                    mContext.startActivity(intent);
                }
                if(mall.getName().equals("儿童生长痛的治疗")){
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra(MallActivity.FRUIT_NAME, mall.getName());
                    intent.putExtra(MallActivity.FRUIT_IMAGE_ID, mall.getImageId());
                    mContext.startActivity(intent);
                }
               }
        });
    return holder;
}
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Mall mall = mMallList.get(position);
        holder.fruitName.setText(mall.getName());
        Glide.with(mContext).load(mall.getImageId()).into(holder.fruitImage);
    }
    @Override
    public int getItemCount(){
        return mMallList.size();
    }
}

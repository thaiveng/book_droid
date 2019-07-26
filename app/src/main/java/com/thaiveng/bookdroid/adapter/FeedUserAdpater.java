package com.thaiveng.bookdroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.thaiveng.bookdroid.R;
import com.thaiveng.bookdroid.model.FeedUserModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class FeedUserAdpater extends RecyclerView.Adapter<FeedUserAdpater.MyViewholder> {

    private List<FeedUserModel> feedUserList;


    public FeedUserAdpater(List<FeedUserModel> feedUserList, Context context) {
        this.feedUserList = feedUserList;
    }


    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_user_item, viewGroup, false);

        return new MyViewholder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedUserAdpater.MyViewholder myViewholder, int i) {

        myViewholder.tvUsername.setText(feedUserList.get(i).getUsername());
        myViewholder.tvFollower.setText(feedUserList.get(i).getFollower());
        myViewholder.tvRecommendation.setText(feedUserList.get(i).getRecommendation());
        myViewholder.imgUserFeed.setImageResource(feedUserList.get(i).getImg_user_feed());
    }

    @Override
    public int getItemCount() {
        return feedUserList.size();
    }


    class MyViewholder extends RecyclerView.ViewHolder {
        TextView tvUsername;
        TextView tvFollower;
        TextView tvRecommendation;
        CircleImageView imgUserFeed;

        MyViewholder(@NonNull View itemView) {
            super(itemView);


            tvUsername = itemView.findViewById(R.id.tv_username_feed);
            tvFollower = itemView.findViewById(R.id.tv_follower_feed);
            tvRecommendation = itemView.findViewById(R.id.tv_recommendation_feed);
            imgUserFeed = itemView.findViewById(R.id.img_user_feed);
        }
    }

}

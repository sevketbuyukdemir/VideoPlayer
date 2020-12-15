package com.sevketbuyukdemir.videoplayer.ViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sevketbuyukdemir.videoplayer.R;

import static com.sevketbuyukdemir.videoplayer.MainActivity.VideoArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.VideoRecyclerviewViewHolder> {
    Context context;
    LayoutInflater layoutInflater;

    public CustomRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VideoRecyclerviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.recycler_video_item_view, parent, false);
        VideoRecyclerviewViewHolder vh = new VideoRecyclerviewViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoRecyclerviewViewHolder holder, int position) {
        if(VideoArrayList.size() == 0){
            holder.image_view_video_item.setImageResource(R.mipmap.ic_launcher);
            holder.text_view_video_name.setText("empty");
        }else{
            holder.image_view_video_item.setImageBitmap(VideoArrayList.get(position).getVideo_image());
            holder.text_view_video_name.setText(VideoArrayList.get(position).getTitle());
        }
        //card view
        holder.relative_layout_video_card.setTag(holder);
    }

    @Override
    public int getItemCount() {
        return (VideoArrayList == null) ? 0 : VideoArrayList.size();
    }

    public class VideoRecyclerviewViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view_video_item;
        TextView text_view_video_name;
        RelativeLayout relative_layout_video_card;
        public VideoRecyclerviewViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view_video_item = itemView.findViewById(R.id.image_view_video_item);
            text_view_video_name = itemView.findViewById(R.id.text_view_video_name);
            relative_layout_video_card = itemView.findViewById(R.id.relative_layout_video_card);
        }
    }
}

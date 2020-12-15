package com.sevketbuyukdemir.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.sevketbuyukdemir.videoplayer.Utils.FileProcesses;
import com.sevketbuyukdemir.videoplayer.Utils.RecyclerItemClickListener;
import com.sevketbuyukdemir.videoplayer.Utils.Video;
import com.sevketbuyukdemir.videoplayer.ViewAdapters.CustomRecyclerViewAdapter;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    public static ArrayList<Video> VideoArrayList = new ArrayList<>();
    RecyclerView video_recycler_view;
    CustomRecyclerViewAdapter customRecyclerViewAdapter;
    VideoView videoView;
    MediaController mediaController;
    MediaController.MediaPlayerControl mediaPlayerControl;

    public void init(){
        mediaController = new MediaController(context);
        videoView = findViewById(R.id.videoView);

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        customRecyclerViewAdapter = new CustomRecyclerViewAdapter(context);

        video_recycler_view = findViewById(R.id.video_recycler_view);
        video_recycler_view.setLayoutManager(llm);
        video_recycler_view.setAdapter(customRecyclerViewAdapter);

        ArrayList<File> video_files = FileProcesses.getAllAudioFiles(context);
        VideoArrayList = FileProcesses.createVideoObjectsArrayList(video_files);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        video_recycler_view.addOnItemTouchListener(new RecyclerItemClickListener(context,
                video_recycler_view,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        videoView.setVideoURI(VideoArrayList.get(position).getUri());
                        videoView.requestFocus();
                        videoView.start();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
    }


}
package com.sevketbuyukdemir.videoplayer.Utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;

public interface FileProcesses {

    public static ArrayList<File> getAllAudioFiles(Context c) {
        ArrayList<File> files = new ArrayList<>();
        String[] projection = { MediaStore.Video.VideoColumns.DATA ,MediaStore.Video.Media.DISPLAY_NAME};
        Cursor cursor = c.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        try {
            cursor.moveToFirst();
            do{
                files.add((new File(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)))));
            }while(cursor.moveToNext());

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

    public static ArrayList<Video> createVideoObjectsArrayList(ArrayList<File> video_files){
        ArrayList<Video> videos = new ArrayList<Video>();
        try{
            for(int i = 0; i < video_files.size(); i++) {
                Uri uri = Uri.fromFile(video_files.get(i));
                Bitmap video_image = ThumbnailUtils.createVideoThumbnail(video_files.get(i).getPath(),
                        MediaStore.Images.Thumbnails.MINI_KIND);;
                String title = video_files.get(i).getName();
                Video video = new Video(uri, video_image, title);
                videos.add(video);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videos;
    }
}

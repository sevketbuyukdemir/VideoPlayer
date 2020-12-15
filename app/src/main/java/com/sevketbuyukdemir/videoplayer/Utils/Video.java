package com.sevketbuyukdemir.videoplayer.Utils;

import android.graphics.Bitmap;
import android.net.Uri;

public class Video {
    Uri uri;
    Bitmap video_image;
    String title;

    public Video(Uri uri, Bitmap video_image, String title) {
        this.uri = uri;
        this.video_image = video_image;
        this.title = title;
    }

    public Uri getUri() {
        return uri;
    }

    public Bitmap getVideo_image() {
        return video_image;
    }

    public String getTitle() {
        return title;
    }

}

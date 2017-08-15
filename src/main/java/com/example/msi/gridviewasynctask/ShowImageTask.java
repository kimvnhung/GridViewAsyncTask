package com.example.msi.gridviewasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MSI on 8/15/2017.
 */

public class ShowImageTask extends AsyncTask<String,Void,Bitmap> {
    ImageView imageView;

    public ShowImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap result = null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            result = BitmapFactory.decodeStream(inputStream);
            if (result!=null){
                return result;
            }
        }catch (Exception e){

        }
        return result;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}

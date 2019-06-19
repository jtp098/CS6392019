package com.example.asynctaskproject;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * A placeholder fragment containing a simple view.
 */
public class ImageFragmentFragment extends Fragment {
   public String url = "https://raw.githubusercontent.com/jtp098/cs6392019/master/Boston.png";
    ImageView imageview;

    public ImageFragmentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image_fragment, container, false);
         imageview = (ImageView) view.findViewById(R.id.image_View);
        new DownloadImage().execute(url);
        return view;
    }


    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... parms) {


            Bitmap bitmap = null;
            try {
                URL url = new URL(parms[0]);
                HttpURLConnection con = (HttpsURLConnection)url.openConnection();
                if(con.getResponseCode() != 200){
                    throw new Exception("Failed to Connect");
                }
                InputStream is = con.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                return bitmap;
            }catch(Exception e){
                    Log.e("Image", "Failed to load Image", e);
                    Log.e("error", e.getMessage());
                }
                    return bitmap;
                }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageview.setImageBitmap(bitmap);

        }
    }

        }





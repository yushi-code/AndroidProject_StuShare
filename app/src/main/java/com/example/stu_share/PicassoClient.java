package com.example.stu_share;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoClient {

    public static void downloadImage(Context c, String imageUrl, ImageView img)
    {
        if(imageUrl.length()>0 && imageUrl!=null)
        {
            Picasso.with(c).load(imageUrl).placeholder(R.drawable.jif).into(img);
        }else {
            Picasso.with(c).load(R.drawable.jif).into(img);
        }
    }

}

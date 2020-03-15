package com.example.stu_share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.stu_share.EventCoordinator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class UserAdapter extends ArrayAdapter<User> {

    private Context mContext;
    private List<User> userList = new ArrayList<>();

    public UserAdapter(@NonNull Context context, ArrayList<User> list) {
        super(context, 0 , list);
        mContext = context;
        userList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        User currentUser = userList.get(position);

        // ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
        //\
        PicassoClient.downloadImage(mContext,currentUser.getmImageDrawable(), image);
        //image.setImageResource(currentEvent.getmImageDrawable());

        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentUser.getFirstName());

        TextView release = (TextView) listItem.findViewById(R.id.textView_release);
        release.setText(currentUser.getEmail());

        return listItem;
    }
}




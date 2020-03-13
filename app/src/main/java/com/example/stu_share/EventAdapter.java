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


public class EventAdapter extends ArrayAdapter<EventCoordinator.Event> {

    private Context mContext;
    private List<EventCoordinator.Event> eventList = new ArrayList<>();

    public EventAdapter(@NonNull Context context, ArrayList<EventCoordinator.Event> list) {
        super(context, 0 , list);
        mContext = context;
        eventList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        EventCoordinator.Event currentEvent = eventList.get(position);

       // ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
        ImageView image = (ImageView)listItem.findViewById(R.id.imageView_poster);
        PicassoClient.downloadImage(mContext,currentEvent.getmImageDrawable(), image);
        //image.setImageResource(currentEvent.getmImageDrawable());

        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentEvent.getEventTitle());

        TextView release = (TextView) listItem.findViewById(R.id.textView_release);
        release.setText(currentEvent.getEventDetail());

        return listItem;
    }
}



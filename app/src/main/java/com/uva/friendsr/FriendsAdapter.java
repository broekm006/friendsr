package com.uva.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;

    // create friends adapter
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        this.friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // get image + text location
        ImageView image = convertView.findViewById(R.id.imageView);
        TextView text = convertView.findViewById(R.id.name);
        Friend friend = friends.get(position);

        // update image + text accordion to the position of the friend
        text.setText(friends.get(position).getName());
        image.setImageDrawable(getContext().getResources().getDrawable(friend.getDrawableId()));

       return convertView;
    }
}

package com.uva.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;

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

        ImageView image = convertView.findViewById(R.id.imageView);
        TextView text = convertView.findViewById(R.id.name);

        text.setText(friends.get(position).getName());

        switch (friends.get(position).getName()){
            case "arya": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.arya));
                break;
            case "cersei": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.cersei));
                break;
            case "daenerys": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.daenerys));
                break;
            case "jaime": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.jaime));
                break;
            case "jon": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.jon));
                break;
            case "jorah": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.jorah));
                break;
            case "margaery": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.margaery));
                break;
            case "melisandre": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.melisandre));
                break;
            case "sansa": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.sansa));
                break;
            case "Tyrion": image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.tyrion));
                break;

        }
        return convertView;
    }
}

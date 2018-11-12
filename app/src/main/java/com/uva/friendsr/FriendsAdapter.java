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

        for (int i = 0; i < friends.size(); i++){

        }

        ImageView image = convertView.findViewById(R.id.imageView);
        TextView text = convertView.findViewById(R.id.name);


        image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.arya));
        text.setText("Arya");
        switch (friends.get(position).getName()){
            case "arya":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.arya));
                text.setText("Arya");
                break;
            case "cersei":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.cersei));
                text.setText("Cersei");
                break;
            case "daenerys":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.daenerys));
                text.setText("Daenerys");
                break;
            case "jaime":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.jaime));
                text.setText("Jaime");
                break;
            case "jon":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.jon));
                text.setText("Jon");
                break;
            case "jorah":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.jorah));
                text.setText("Jorah");
                break;
            case "margaery":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.margaery));
                text.setText("Margaery");
                break;
            case "melisandre":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.melisandre));
                text.setText("Melisandre");
                break;
            case "sansa":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.sansa));
                text.setText("Sansa");
                break;
            case "tyrion":
                image.setImageDrawable(getContext().getResources().getDrawable(R.drawable.tyrion));
                text.setText("Tyrion");
                break;

        }
        return convertView;
    }
}

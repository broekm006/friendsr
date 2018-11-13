package com.uva.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    Friend retrievedFriend;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    RatingBar rating_bar_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView image = findViewById(R.id.imageView2);
        TextView txt = findViewById(R.id.textView);
        TextView bio = findViewById(R.id.textView2);

        txt.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());
        System.out.println(retrievedFriend.getDrawableId());
        //img.setImageResource(retrievedFriend.getDrawableId());
        //image.setImageDrawable(getDrawable(retrievedFriend.getDrawableId()));

        switch (retrievedFriend.getName()) {
            case "arya":
                image.setImageDrawable(getResources().getDrawable(R.drawable.arya));
                break;
            case "cersei":
                image.setImageDrawable(getResources().getDrawable(R.drawable.cersei));
                break;
            case "daenerys":
                image.setImageDrawable(getResources().getDrawable(R.drawable.daenerys));
                break;
            case "jaime":
                image.setImageDrawable(getResources().getDrawable(R.drawable.jaime));
                break;
            case "jon":
                image.setImageDrawable(getResources().getDrawable(R.drawable.jon));
                break;
            case "jorah":
                image.setImageDrawable(getResources().getDrawable(R.drawable.jorah));
                break;
            case "margaery":
                image.setImageDrawable(getResources().getDrawable(R.drawable.margaery));
                break;
            case "melisandre":
                image.setImageDrawable(getResources().getDrawable(R.drawable.melisandre));
                break;
            case "sansa":
                image.setImageDrawable(getResources().getDrawable(R.drawable.sansa));
                break;
            case "Tyrion":
                image.setImageDrawable(getResources().getDrawable(R.drawable.tyrion));
                break;
        }

        prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();

        Float aStoredFloat = prefs.getFloat("settings", 0);

        rating_bar_id = findViewById(R.id.ratingBar);
        rating_bar_id.setOnRatingBarChangeListener(new RatingBarClickListener());

        if (aStoredFloat != 0) {
            rating_bar_id.setRating(aStoredFloat);
        }

        else{
            rating_bar_id.setRating(0);
        }

    }

    private class RatingBarClickListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            retrievedFriend.setRating(ratingBar.getRating());
            editor.putFloat("settings", v);
            editor.apply();
        }
    }


}

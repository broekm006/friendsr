package com.uva.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    Friend retrievedFriend;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    RatingBar rating_bar_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get info from main
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView image = findViewById(R.id.imageView2);
        TextView name = findViewById(R.id.textView);
        TextView bio = findViewById(R.id.textView2);

        // update name, bio and image
        name.setText(retrievedFriend.getName());
        bio.setText(retrievedFriend.getBio());
        image.setImageDrawable(getDrawable(retrievedFriend.getDrawableId()));

        // setup memory management
        prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();

        float aStoredFloat = prefs.getFloat(retrievedFriend.getName(), 0);

        // get ratingbar and update it with the correct value
        rating_bar_id = findViewById(R.id.ratingBar);
        rating_bar_id.setOnRatingBarChangeListener(new RatingBarClickListener());

        if (aStoredFloat != 0) {
            rating_bar_id.setRating(aStoredFloat);
        }

        else{
            rating_bar_id.setRating(0);
        }

    }

    // update + save rating when rating bar is changed
    private class RatingBarClickListener implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            retrievedFriend.setRating(ratingBar.getRating());
            editor.putFloat(retrievedFriend.getName(), v);
            editor.apply();
        }
    }


}

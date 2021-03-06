package com.uva.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Friend> friends = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create all the friends
        Friend arya = new Friend("Faceless Trainee", "arya", getResources().getIdentifier("arya", "drawable", getPackageName()));
        Friend cersei = new Friend("Bitch Queen", "cersei", getResources().getIdentifier("cersei", "drawable", getPackageName()));
        Friend daenerys = new Friend("Queen of Dragons", "daenerys", getResources().getIdentifier("daenerys", "drawable", getPackageName()));
        Friend jaime = new Friend("Can't Decide Kingsknight", "jaime", getResources().getIdentifier("jaime", "drawable", getPackageName()));
        Friend jon = new Friend("King of the North", "jon", getResources().getIdentifier("jon", "drawable", getPackageName()));
        Friend jorah = new Friend("Warrior with honor", "jorah", getResources().getIdentifier("jorah", "drawable", getPackageName()));
        Friend margaery = new Friend("Enter generic description here", "margaery", getResources().getIdentifier("margaery", "drawable", getPackageName()));
        Friend melisandre = new Friend("Speaks all Languages", "melisandre", getResources().getIdentifier("melisandre", "drawable", getPackageName()));
        Friend sansa = new Friend("Ramsys \"toy\"", "sansa", getResources().getIdentifier("sansa", "drawable", getPackageName()));
        Friend tyrion = new Friend("Absolute Badass", "Tyrion", getResources().getIdentifier("tyrion", "drawable", getPackageName()));

        // add friends to the list
        friends.add(arya);
        friends.add(cersei);
        friends.add(daenerys);
        friends.add(jaime);
        friends.add(jon);
        friends.add(jorah);
        friends.add(margaery);
        friends.add(melisandre);
        friends.add(sansa);
        friends.add(tyrion);

        // create adapter / gridview
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridView = (GridView) findViewById(R.id.griddy);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    // on click update the ui to specific profile
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            System.out.println(clickedFriend.getName());


            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


}

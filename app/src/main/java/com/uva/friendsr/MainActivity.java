package com.uva.friendsr;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Friend> friends = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Friend arya = new Friend("Faceless Trainee", "arya", getResources().getIdentifier("arya.png", "id", getPackageName()));
        Friend cersei = new Friend("Bitch Queen", "cersei", getResources().getIdentifier("cersei.png", "id", getPackageName()));
        Friend daenerys = new Friend("Queen of Dragons", "daenerys", getResources().getIdentifier("daenerys.png", "id", getPackageName()));
        Friend jaime = new Friend("Can't Decide Kingsknight", "jaime", getResources().getIdentifier("jaime.png", "id", getPackageName()));
        Friend jon = new Friend("King of the North", "jon", getResources().getIdentifier("jon.png", "id", getPackageName()));
        Friend jorah = new Friend("Warrior with honor", "jorah", getResources().getIdentifier("jorah.png", "id", getPackageName()));
        Friend margaery = new Friend("Enter generic description here", "margaery", getResources().getIdentifier("margaery.png", "id", getPackageName()));
        Friend melisandre = new Friend("Speaks all Languages", "melisandre", getResources().getIdentifier("melisandre.png", "id", getPackageName()));
        Friend sansa = new Friend("Ramsys \"toy\"", "sansa", getResources().getIdentifier("sansa.png", "id", getPackageName()));
        Friend tyrion = new Friend("Absolute Badass", "Tyrion", getResources().getIdentifier("tyrion.png", "id", getPackageName()));

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


        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridView = (GridView) findViewById(R.id.griddy);
        gridView.setAdapter(adapter);
    }



}

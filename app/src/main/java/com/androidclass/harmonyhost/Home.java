package com.androidclass.harmonyhost;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    EditText editText;
    Button btn1;

    String playername = "";

    FirebaseDatabase database;
    DatabaseReference playerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editText = (EditText) findViewById(R.id.editTextPersonName);
        btn1 = (Button) findViewById(R.id.roomLogInBtn);

        database = FirebaseDatabase.getInstance();

        /*Check if the player exists*/
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        playername = preferences.getString("playerName", "");
        if(!playername.equals(""))
        {
            playerRef = database.getReference("players/" + playername);
            addEventListener();
            playerRef.setValue("");
        }

        /*logging the player in*/
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playername = editText.getText().toString();
                editText.setText("");
                if(!playername.equals(""))
                {
                    btn1.setText("Logging In!");
                    btn1.setEnabled(false);
                    playerRef = database.getReference("players/" + playername);
                    addEventListener();
                    playerRef.setValue("");
                }
            }
        });

    }

    /*read from database*/
    private void addEventListener()
    {
        playerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //saves player name and enters room then
                if(!playername.equals(""))
                {
                    SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("playerName", playername);
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), Room.class));
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                //error message
                btn1.setText("Log In");
                btn1.setEnabled(true);
                Toast.makeText(Home.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
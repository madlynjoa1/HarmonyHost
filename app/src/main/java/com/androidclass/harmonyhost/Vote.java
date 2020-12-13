package com.androidclass.harmonyhost;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Vote extends AppCompatActivity {
    DatabaseReference databaseReference, likesReference;
    RecyclerView recyclerView;
    FirebaseDatabase database;
    String name, url;
    Boolean likeChecker = false;

    TextView song1, song2, song3, song4, song5, song6, song7, song8, song9, song10;
    ImageButton like1, like2, like3, like4, like5, like6, like7, like8, like9, like10;
    TextView songLike1, songLike2, songLike3, songLike4, songLike5, songLike6, songLike7, songLike8, songLike9, songLike10;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Songs");
        likesReference = database.getReference("Likes");

        song1 = (TextView) findViewById(R.id.textView1);
        song2 = (TextView) findViewById(R.id.textView2);
        song3 = (TextView) findViewById(R.id.textView3);
        song4 = (TextView) findViewById(R.id.textView4);
        song5 = (TextView) findViewById(R.id.textView5);
        song6 = (TextView) findViewById(R.id.textView6);
        song7 = (TextView) findViewById(R.id.textView7);
        song8 = (TextView) findViewById(R.id.textView8);
        song9 = (TextView) findViewById(R.id.textView9);
        song10 = (TextView) findViewById(R.id.textView10);

        like1 = (ImageButton) findViewById(R.id.like_btn1);
        like2 = (ImageButton) findViewById(R.id.like_btn2);
        like3 = (ImageButton) findViewById(R.id.like_btn3);
        like4 = (ImageButton) findViewById(R.id.like_btn4);
        like5 = (ImageButton) findViewById(R.id.like_btn5);
        like6 = (ImageButton) findViewById(R.id.like_btn6);
        like7 = (ImageButton) findViewById(R.id.like_btn7);
        like8 = (ImageButton) findViewById(R.id.like_btn8);
        like9 = (ImageButton) findViewById(R.id.like_btn9);
        like10 = (ImageButton) findViewById(R.id.like_btn10);

        songLike1 = (TextView) findViewById(R.id.likes_textview1);
        songLike2 = (TextView) findViewById(R.id.likes_textview2);
        songLike3 = (TextView) findViewById(R.id.likes_textview3);
        songLike4 = (TextView) findViewById(R.id.likes_textview4);
        songLike5 = (TextView) findViewById(R.id.likes_textview5);
        songLike6 = (TextView) findViewById(R.id.likes_textview6);
        songLike7 = (TextView) findViewById(R.id.likes_textview7);
        songLike8 = (TextView) findViewById(R.id.likes_textview8);
        songLike9 = (TextView) findViewById(R.id.likes_textview9);
        songLike10 = (TextView) findViewById(R.id.likes_textview10);

        submit = (Button) findViewById(R.id.submitButton);

    }

    /*@Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Member> options =
                new FirebaseRecyclerOptions.Builder<Member>()
                        .setQuery(databaseReference, Member.class)
                        .build();

        FirebaseRecyclerAdapter<Member, RecyclerView.ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Member, RecyclerView.ViewHolder>(options) {
                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        return null;
                    }

                    @NonNull
                    @Override
                    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        return null;
                    }

                    @Override
                    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull Member model) {

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        String currentUserId = user.getUid();
                        final String postkey = getRef(position).getKey();

                        holder.downloadbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                            PackageManager.PERMISSION_DENIED) {
                                        String permission = (Manifest.permission.WRITE_EXTERNAL_STORAGE);
                                        requestPermissions(new String[]{permission}, PERMISSION_STORAGE_CODE);
                                    }
                                } else {

                                    startDownloading(downloadurl);
                                }

                            }
                        });

                    }
                };

    }*/
}

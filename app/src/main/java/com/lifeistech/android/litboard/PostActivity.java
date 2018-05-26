package com.lifeistech.android.litboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity implements View.OnClickListener{

    //for firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference("message");

    //view component
    EditText mUsernameText;
    EditText mPostText;
    Button mPostButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mUsernameText = (EditText)findViewById(R.id.username);
        mPostText = (EditText)findViewById(R.id.message);
        mPostButton = (Button)findViewById(R.id.post);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.post:
                //TODO 投稿ボタンを押したときの処理

                //投稿を作る．
                String userName = mUsernameText.getText().toString();
                String message = mPostText.getText().toString();
                Post post = new Post(userName,message);


                //投稿する．
                refMsg.push().setValue(post);


                //アクティビティを閉じる．
                finish();

                break;

        }
    }
}

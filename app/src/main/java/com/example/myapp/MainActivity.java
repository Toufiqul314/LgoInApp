package com.example.myapp;

import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.*;
import android.widget.*;

import androidx.appcompat.app.*;

import com.google.firebase.auth.*;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;
protected void onCreat(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    auth=FirebaseAuth.getInstance();
    button=findViewById(R.id.logout);
    textView=findViewById(R.id.user_details);
    user=auth.getCurrentUser();
    if(user==null){
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();

    }
    else {
textView.setText(user.getEmail());
    }
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FirebaseAuth.getInstance().signOut();
            Intent intent=new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();
        }
    });
}
}

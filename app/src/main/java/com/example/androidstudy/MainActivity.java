package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidstudy.http.HttpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoHttp(View view) {
        Intent intent = new Intent(MainActivity.this, HttpActivity.class);
        startActivity(intent);
    }
}

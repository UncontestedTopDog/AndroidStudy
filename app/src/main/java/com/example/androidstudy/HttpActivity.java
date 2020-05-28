package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.http.MovieManager;
import com.example.http.data.MovieData;

public class HttpActivity extends AppCompatActivity {

    Button getData;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        getData = findViewById(R.id.get_data);
        result = findViewById(R.id.result);

        getData.setOnClickListener(v->{
            MovieManager.getInstance().getData()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<MovieData>() {
                        @Override
                        public void call(MovieData movieData) {
                            Log.i("success: ",movieData.toString());
                            result.setText(movieData.toString());
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.i("fail: ",throwable.toString());
                            result.setText(throwable.toString());
                        }
                    });
        });
    }
}

package com.zjf.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zjf.widget.widget.SearchEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchEditText editText = findViewById(R.id.et);
        editText.setOnClearTextListener(new SearchEditText.OnClearTextListener() {
            @Override
            public void onClearTextListener() {
                //点击清除文本的监听
                Toast.makeText(MainActivity.this, "清除文本", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

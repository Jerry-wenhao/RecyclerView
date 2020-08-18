package com.xiawenhao.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.main_button,
            R.id.header_button,
            R.id.image_button})

    public void recyclerViewButtons(Button button) {
        switch (button.getId()) {
            case R.id.main_button:
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                break;
            case R.id.header_button:
                startActivity(new Intent(MainActivity.this, MultipleListActivity.class));
                break;
            case R.id.image_button:
                startActivity(new Intent(MainActivity.this, ImageListActivity.class));
                break;
        }
    }
}



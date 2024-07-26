package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView imageView = findViewById(R.id.logo);

        // Atur parameter layout baru
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = 600;
        imageView.setLayoutParams(params);
    }
}

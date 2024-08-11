package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileAvtivity extends AppCompatActivity {
    ImageView rightIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_avtivity);

        // Retrieve the username from the Intent extras
        String username = getIntent().getStringExtra("USERNAME");

        // Find the TextView and set the username
        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        welcomeTextView.setText("Hi, " + username);

        TextView userTextView = findViewById(R.id.userEmail);
        userTextView.setText( username + "@gmail.com");

        rightIcon = findViewById(R.id.right_icon);

        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.profile_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            String username = getIntent().getStringExtra("USERNAME");
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intents = new Intent(ProfileAvtivity.this, HomeActivity.class);
                        intents.putExtra("USERNAME", username); // Pass the username
                        startActivity(intents);
                        return true;
                    case R.id.items:
                        Intent intentss = new Intent(ProfileAvtivity.this, ListItemActivity.class);
                        intentss.putExtra("USERNAME", username); // Pass the username
                        startActivity(intentss);
                        return true;
                    case R.id.profile:
                        return true;
                    case R.id.logout:
                        Toast.makeText(ProfileAvtivity.this, "Logging out...", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(ProfileAvtivity.this, LoginActivity.class);
                        startActivity(intent);

                        finish();
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }
}
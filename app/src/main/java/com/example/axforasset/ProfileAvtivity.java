package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ProfileAvtivity extends AppCompatActivity {
    ImageView rightIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_avtivity);

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
        popupMenu.getMenuInflater().inflate(R.menu.home_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(ProfileAvtivity.this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.items:
                        Toast.makeText(ProfileAvtivity.this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.profile:
                        Toast.makeText(ProfileAvtivity.this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
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
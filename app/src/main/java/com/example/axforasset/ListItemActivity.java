package com.example.axforasset;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListItemActivity extends AppCompatActivity {

    ImageView rightIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items); // Use the corresponding layout file for your Activity

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //Menu in here
        rightIcon = findViewById(R.id.right_icon);

        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        List<Product> ProductList = new ArrayList<>();
        ProductList.add(new Product("Treasure Hunt", "Uncover the secrets of lost riches with this intricately crafted ancient treasure map, an essential tool for any daring treasure hunter. Hand-drawn on weathered parchment, the map is adorned with faded ink markings","Perfect for developers and players who crave immersive exploration.", R.drawable.game_icon1));
        ProductList.add(new Product("Werewolf","Unleash the primal terror with this formidable werewolf character model, designed to haunt players' nightmares. Towering and muscular, this creature is a hybrid of human and wolf, with menacing yellow eyes that pierce the darkness.", "Explore eerie landscapes, engage in intense multiplayer battles.",R.drawable.game_icon2));
        ProductList.add(new Product("Survival Game","Equip your players for the ultimate survival challenge with this rugged and versatile backpack. Crafted from durable canvas and reinforced with weatherproof stitching, this essential gear item is designed to withstand the harshest environments.", "Embark on an immersive survival experience in Survival Quest.", R.drawable.game_icon3));
        ProductList.add(new Product("Pirate Game","Set sail for adventure with this intricately crafted pirate treasure chest! Perfect for any swashbuckling game environment, this asset features weathered wood adorned with brass fittings and intricate carvings. The chest is securely locked with a rusty padlock, hinting at the riches within.", "Make your ship, recruit a skilled crew, and navigate treacherous waters.", R.drawable.game_icon4));
        ProductList.add(new Product("Space Shooter","Embark on an interstellar journey with this sleek and formidable space fighter ship, designed for high-speed combat and exploration in the depths of space. Featuring a streamlined hull plated with advanced composite armor, this vessel exudes futuristic elegance and lethal efficiency.", "Engage in an adrenaline-pumping space shooter.", R.drawable.game_icon5));
        productViewAdapter adapter = new productViewAdapter(this, ProductList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
//        return view;
    }

    //    menu pop up
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.item_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            String username = getIntent().getStringExtra("USERNAME");

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intentss = new Intent(ListItemActivity.this, HomeActivity.class);
                        intentss.putExtra("USERNAME", username); // Pass the username
                        startActivity(intentss);
                        return true;
                    case R.id.profile:
                        Intent intents = new Intent(ListItemActivity.this, ProfileAvtivity.class);
                        intents.putExtra("USERNAME", username); // Pass the username
                        startActivity(intents);
                        return true;
                    case R.id.logout:
                        Toast.makeText(ListItemActivity.this, "Logging out...", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(ListItemActivity.this, LoginActivity.class);
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

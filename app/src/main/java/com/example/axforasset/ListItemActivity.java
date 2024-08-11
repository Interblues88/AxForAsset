package com.example.axforasset;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items); // Use the corresponding layout file for your Activity

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

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
}

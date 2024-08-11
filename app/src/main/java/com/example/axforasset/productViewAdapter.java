package com.example.axforasset;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.axforasset.Product;

import java.util.List;

public class productViewAdapter extends RecyclerView.Adapter<productViewAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> ProductList;

    public productViewAdapter(Context context, List<Product> ProductList) {
        this.context = context;
        this.ProductList = ProductList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_itemlist, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product Product = ProductList.get(position);
        holder.title.setText(Product.getTitle());
//        holder.preview.setText(Product.getPreview());
        holder.description.setText(Product.getDescription());
        holder.image.setImageResource(Product.getImageId());
        holder.button.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("EXTRA_TITLE", Product.getTitle());
            intent.putExtra("EXTRA_PREVIEW", Product.getPreview());
            intent.putExtra("EXTRA_IMAGE_ID", Product.getImageId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return ProductList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView title, description,preview;
        ImageView image;
        Button button;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
//            preview = itemView.findViewById(R.id.item_preview);
            description = itemView.findViewById(R.id.item_description);
            image = itemView.findViewById(R.id.item_image);
            button = itemView.findViewById(R.id.item_button);
        }
    }
}

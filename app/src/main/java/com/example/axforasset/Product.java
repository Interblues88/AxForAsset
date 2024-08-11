package com.example.axforasset;

import java.util.Vector;

public class Product {
    private String title;
    private String preview;
    private String description;
    private Integer imageId;
    public static Vector<Product> listProducts = new Vector<>();
//    public Product(String productName, Integer productPrice){
//        this.productName =productName;
//        this.productPrice = productPrice;
//        listProducts.add(this);
//    }


    public Product(String title, String preview, String description, Integer imageId) {
        this.title = title;
        this.preview = preview;
        this.description = description;
        this.imageId = imageId;
    }


    public String getTitle() {
        return title;
    }

    public String getPreview() {
        return preview;
    }

    public Integer getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }

    public static Vector<Product> getListProducts() {
        return listProducts;
    }

}

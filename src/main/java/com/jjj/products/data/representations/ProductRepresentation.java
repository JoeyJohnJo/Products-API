package com.jjj.products.data.representations;

import com.jjj.products.data.entities.Product;

//Representation of the product class, returned by the API
//This way, if changes are made to the Entity, the API isn't broken
public class ProductRepresentation {

    private Long id;
    private String name;
    private Float buyingPrice, sellingPrice;
    private Integer quantity;

    public ProductRepresentation(Product product) {
        id = product.getId();
        name = product.getName();
        buyingPrice = product.getBuyingPrice();
        sellingPrice = product.getSellingPrice();
        quantity = product.getQuantity();
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Float getBuyingPrice() {
        return buyingPrice;
    }
    public Float getSellingPrice() {
        return sellingPrice;
    }
    public Integer getQuantity() {
        return quantity;
    }
}

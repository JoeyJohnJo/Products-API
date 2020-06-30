package com.jjj.products.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Nome do produto não pode ser vazio")
    private String name;
    @Min(value = 0, message = "Preço de compra não pode ser menor que zero")
    private Float buyingPrice;
    @Min(value = 0, message = "Preço de venda não pode ser menor que zero")
    private Float sellingPrice;
    @Min(value = 0, message = "Não pode haver menos que zero produtos no estoque")
    private Integer quantity;

    //Getters and Setters

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

    public void setName(String name) {
        this.name = name;
    }
    public void setBuyingPrice(Float buyingPrice) {
        this.buyingPrice = buyingPrice;
    }
    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

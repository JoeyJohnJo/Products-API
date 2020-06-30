package com.jjj.products.errors.exceptions;

public class ProductNotFoundException extends RuntimeException  {
    public ProductNotFoundException(Long id) {
        super("Produto não encontrado com o id: " + id);
    }
}

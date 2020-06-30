package com.jjj.products.controllers;

import com.jjj.products.data.entities.Product;
import com.jjj.products.data.representations.ProductRepresentation;
import com.jjj.products.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired private ProductUtils utils;

    //List all products
    @GetMapping("")
    List<ProductRepresentation> findAll() {
        return utils.findAll();
    }
    //Add a product to the database
    @PostMapping("")
    ProductRepresentation addProduct(@RequestBody @Valid Product product) {
        return utils.addProduct(product);
    }
    //Update a product from the database
    @PutMapping("")
    ProductRepresentation updateProduct(@RequestBody @Valid Product product) {
        return utils.updateProduct(product);
    }
    //Return a single product by id
    @GetMapping("/{id}")
    ProductRepresentation findById(@PathVariable Long id) {
        return utils.findById(id);
    }
    //Delete a single product by id
    @DeleteMapping("/{id}")
    List<ProductRepresentation> deleteProduct(@PathVariable Long id) {
        return utils.deleteProduct(id);
    }
}

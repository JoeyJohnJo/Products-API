package com.jjj.products.utils;

import com.jjj.products.data.accessors.ProductAccessor;
import com.jjj.products.data.entities.Product;
import com.jjj.products.data.representations.ProductRepresentation;
import com.jjj.products.errors.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductUtils {

    @Autowired private ProductAccessor accessor;

    public List<ProductRepresentation> findAll() {
        List<ProductRepresentation> representationList = new ArrayList<>();
        Iterable<Product> products = accessor.findAll();
        products.forEach(product -> representationList.add(new ProductRepresentation(product)));
        return representationList;
    }

    public ProductRepresentation findById(Long id) {
        Optional<Product> product = accessor.findById(id);
        if (product.isPresent())
            return new ProductRepresentation(product.get());
        else throw new ProductNotFoundException(id);
    }

    public ProductRepresentation addProduct(Product product) {
        return new ProductRepresentation(accessor.save(product));
    }

    public List<ProductRepresentation> deleteProduct(Long id) {
        Optional<Product> product = accessor.findById(id);
        if (product.isPresent()) {
            accessor.delete(product.get());
            //Return the list of products updated without the product just deleted
            return findAll();
        }
        else throw new ProductNotFoundException(id);
    }

    public ProductRepresentation updateProduct(Product product) {
        Optional<Product> inDatabase = accessor.findById(product.getId());
        if (inDatabase.isPresent())
            return new ProductRepresentation(accessor.save(product));
        else throw new ProductNotFoundException(product.getId());
    }
}

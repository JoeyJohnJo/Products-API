package com.jjj.products.data.accessors;

import com.jjj.products.data.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAccessor extends CrudRepository<Product, Long> {
}

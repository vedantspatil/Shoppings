package com.distributedsystems.productservice.respository;

import com.distributedsystems.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

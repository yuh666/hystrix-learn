package org.example.hystrix.product.controller;

import org.example.hystrix.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/get/{id}")
    public Product get(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(1000);
        return new Product(id, "Product" + id);
    }
}

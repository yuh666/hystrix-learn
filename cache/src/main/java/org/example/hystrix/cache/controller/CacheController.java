package org.example.hystrix.cache.controller;

import org.example.hystrix.cache.command.ProductCommand;
import org.example.hystrix.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public Product get(@PathVariable Long id) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    ProductCommand productCommand = new ProductCommand(restTemplate, id);
                    System.out.println(productCommand.execute());

                }
            }).start();
        }
        return new ProductCommand(restTemplate, id).execute();
    }
}

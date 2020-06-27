package org.example.hystrix.cache.command;


import com.netflix.hystrix.*;
import org.example.hystrix.product.model.Product;
import org.springframework.web.client.RestTemplate;

public class ProductCommand extends HystrixCommand<Product> {


    private RestTemplate restTemplate;
    private Long id;

    public ProductCommand(RestTemplate restTemplate, Long id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("GetProduct"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)
                        .withCircuitBreakerErrorThresholdPercentage(50)
                        .withCircuitBreakerRequestVolumeThreshold(5)
                        .withCircuitBreakerSleepWindowInMilliseconds(10000)
                        .withExecutionTimeoutInMilliseconds(100))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)
                        .withMaximumSize(10)
                        .withMaxQueueSize(5)));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected Product run() throws Exception {
        if (id < 0) {
            throw new RuntimeException();
        }
        return restTemplate.getForObject("http://localhost:9001/product/get/" + id, Product.class);
    }

//    @Override
//    protected String getCacheKey() {
//        return id + "";
//    }

    @Override
    protected Product getFallback() {
        return new Product(-999L, "Product9999");
    }
}

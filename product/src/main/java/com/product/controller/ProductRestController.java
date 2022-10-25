package com.product.controller;



import com.product.dto.Coupon;
import com.product.entity.Product;
import com.product.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

    private final ProductRepository productRepository;

    @Value("${couponService.url}")
    private String couponServiceURL;


    @Autowired
    private  RestTemplate restTemplate;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
       Coupon coupon=  restTemplate.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
        assert coupon != null;
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }

    @GetMapping(value = "/products/{id}")
    public Product getCoupon(@PathVariable("id") String name){
        return productRepository.findProductByName(name);
    }

}

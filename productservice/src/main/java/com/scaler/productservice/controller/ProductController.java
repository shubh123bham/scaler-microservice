package com.scaler.productservice.controller;

import com.scaler.productservice.config.dto.User;
import com.scaler.productservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/details")
    @ResponseBody
    public Product getProductDetails(@RequestParam("productid") String productId,
                                     @RequestParam("userid") String userId) {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("Beards and shears hemp face wash");
        product.setProductPrice(249.00);

        ResponseEntity<User> response = restTemplate.getForEntity("http://userservice/user/details/"+userId,User.class);
        User user = response.getBody();
        System.out.println("here is role "+user.getRole());
        product.setPublic(true);
        return product;
    }
}

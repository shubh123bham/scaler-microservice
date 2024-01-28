package com.scaler.productservice.controller;

import com.scaler.productservice.dto.User;
import com.scaler.productservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
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

        User user = restTemplate.getForObject("http://userservice/user/details/"+userId,User.class);
        System.out.println("here is role "+user.getRole());
        product.setPublic(false);
        if(product.isPublic()){
            return product;
        }
        else if(user.getRole().equals("Admin")){
            return product;
        }
        return null;
    }
}

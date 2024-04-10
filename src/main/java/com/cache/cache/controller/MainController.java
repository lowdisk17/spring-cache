package com.cache.cache.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cache.cache.model.Product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("product")
public class MainController {

  private Map<Integer, Product> products = new HashMap<>();

  @GetMapping("getById/{id}")
  @Cacheable(value="product", key="#id")
  @Scheduled(fixedRateString = "30000")
  public Product getMethodName(@PathVariable int id) {
    return products.get(id);
  }

  @PostMapping("save")
  @CachePut(value="product", key="#product.id")
  public Product postMethodName(@RequestBody Product product) {
      products.put(product.getId(), product);
      return product;
  }

  @PutMapping("delete/{id}")
  @CacheEvict(value="product", key="#id")
  public Product putMethodName(@PathVariable int id) {
      products.remove(id);
      return products.get(id);
  }
  
}

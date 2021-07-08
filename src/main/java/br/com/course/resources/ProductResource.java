package br.com.course.resources;

import br.com.course.entities.Product;
import br.com.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource implements Serializable{

  @Autowired
  private ProductService service;

  @GetMapping
  public ResponseEntity<List<Product>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable Integer id){
    return ResponseEntity.ok().body(service.findById(id));
  }
}

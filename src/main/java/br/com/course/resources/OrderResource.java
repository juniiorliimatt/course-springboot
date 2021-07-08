package br.com.course.resources;

import br.com.course.entities.Order;
import br.com.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderResource implements Serializable{

  @Autowired
  private OrderService service;

  @GetMapping
  public ResponseEntity<List<Order>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> findById(@PathVariable Integer id){
    return ResponseEntity.ok().body(service.findById(id));
  }
}

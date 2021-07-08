package br.com.course.services;

import br.com.course.entities.Order;
import br.com.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
public class OrderService implements Serializable{

  @Autowired
  private OrderRepository repository;

  @Transactional
  public List<Order> findAll(){
    return repository.findAll();
  }

  @Transactional
  public Order findById(Integer id){
    return repository.findById(id).get();
  }
}

package br.com.course.services;

import br.com.course.entities.Product;
import br.com.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
public class ProductService implements Serializable{

  @Autowired
  private ProductRepository repository;

  @Transactional
  public List<Product> findAll(){
    return repository.findAll();
  }

  @Transactional
  public Product findById(Integer id){
    return repository.findById(id).get();
  }
}

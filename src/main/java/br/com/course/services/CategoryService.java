package br.com.course.services;

import br.com.course.entities.Category;
import br.com.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
public class CategoryService implements Serializable{

  @Autowired
  private CategoryRepository repository;

  @Transactional
  public List<Category> findAll(){
    return repository.findAll();
  }

  @Transactional
  public Category findById(Integer id){
    return repository.findById(id).get();
  }
}

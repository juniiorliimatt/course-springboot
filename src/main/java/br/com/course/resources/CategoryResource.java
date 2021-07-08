package br.com.course.resources;

import br.com.course.entities.Category;
import br.com.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryResource implements Serializable{

  @Autowired
  private CategoryService service;

  @GetMapping
  public ResponseEntity<List<Category>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable Integer id){
    return ResponseEntity.ok().body(service.findById(id));
  }
}

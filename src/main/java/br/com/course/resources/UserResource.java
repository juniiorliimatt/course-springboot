package br.com.course.resources;

import br.com.course.entities.User;
import br.com.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource implements Serializable{

  @Autowired
  private UserRepository repository;

  @GetMapping
  public ResponseEntity<List<User>> findAll(){
    return ResponseEntity.ok().body(repository.findAll());
  }
}

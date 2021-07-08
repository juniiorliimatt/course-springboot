package br.com.course.resources;

import br.com.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource implements Serializable{

  @GetMapping
  public ResponseEntity<User> findAll(){
    return ResponseEntity.ok().body(new User(1, "Junior", "junior@email.com", "0000-0000", "12345"));
  }
}

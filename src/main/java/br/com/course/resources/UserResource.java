package br.com.course.resources;

import br.com.course.entities.User;
import br.com.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource implements Serializable{

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<User>> findAll(){
    return ResponseEntity.ok().body(service.findAll());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Integer id){
    return ResponseEntity.ok().body(service.findById(id));
  }

  @PostMapping
  public ResponseEntity<User> save(@RequestBody User user){
    URI uri =
        ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).body(service.save(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}

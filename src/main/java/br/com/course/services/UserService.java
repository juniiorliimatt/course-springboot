package br.com.course.services;

import br.com.course.entities.User;
import br.com.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Service
public class UserService implements Serializable{

  @Autowired
  private UserRepository repository;

  @Transient
  public List<User> findAll(){
    return repository.findAll();
  }

  @Transient
  public User findById(Integer id){
    return repository.findById(id).get();
  }
}

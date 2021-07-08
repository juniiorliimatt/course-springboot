package br.com.course.services;

import br.com.course.entities.User;
import br.com.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
public class UserService implements Serializable{

  @Autowired
  private UserRepository repository;

  @Transactional
  public List<User> findAll(){
    return repository.findAll();
  }

  @Transactional
  public User findById(Integer id){
    return repository.findById(id).get();
  }

  @Transactional
  public User save(User user){
    return repository.save(user);
  }

  public void delete(Integer id){
    repository.deleteById(id);
  }
}

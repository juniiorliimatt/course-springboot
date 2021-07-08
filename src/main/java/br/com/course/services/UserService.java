package br.com.course.services;

import br.com.course.entities.User;
import br.com.course.repositories.UserRepository;
import br.com.course.services.exceptions.ResourceNotFoundException;
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
    return repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
  }

  @Transactional
  public User save(User user){
    return repository.save(user);
  }

  @Transactional
  public void delete(Integer id){
    repository.deleteById(id);
  }

  @Transactional
  public User update(Integer id, User user){
    var entity = repository.getById(id);
    updateData(entity, user);
    return repository.save(entity);
  }

  private void updateData(User entity, User user){
    entity.setName(user.getName());
    entity.setEmail(user.getEmail());
    entity.setPhone(user.getPhone());
  }
}

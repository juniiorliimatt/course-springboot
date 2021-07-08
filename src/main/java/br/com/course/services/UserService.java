package br.com.course.services;

import br.com.course.entities.User;
import br.com.course.repositories.UserRepository;
import br.com.course.services.exceptions.DataBaseException;
import br.com.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    try{
      repository.deleteById(id);
    }catch(EmptyResultDataAccessException e){
      throw new ResourceNotFoundException(id);
    }catch(DataIntegrityViolationException e){
      throw new DataBaseException(e.getMessage());
    }
  }

  @Transactional
  public User update(Integer id, User user){
    try{
      var entity = repository.getById(id);
      updateData(entity, user);
      return repository.save(entity);
    }catch(EntityNotFoundException e){
      throw new ResourceNotFoundException(id);
    }
  }

  private void updateData(User entity, User user){
    entity.setName(user.getName());
    entity.setEmail(user.getEmail());
    entity.setPhone(user.getPhone());
  }
}

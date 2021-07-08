package br.com.course.config;

import br.com.course.entities.User;
import br.com.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

  @Autowired
  private UserRepository repository;

  @Override
  public void run(String... args) throws Exception{
    var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
    repository.saveAll(Arrays.asList(u1, u2));
  }
}

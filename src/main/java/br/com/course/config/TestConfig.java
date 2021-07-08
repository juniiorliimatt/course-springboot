package br.com.course.config;

import br.com.course.entities.Category;
import br.com.course.entities.Order;
import br.com.course.entities.User;
import br.com.course.entities.enuns.OrderStatus;
import br.com.course.repositories.CategoryRepository;
import br.com.course.repositories.OrderRepository;
import br.com.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public void run(String... args) throws Exception{
    var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
    userRepository.saveAll(Arrays.asList(u1, u2));

    var o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
    var o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
    var o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");
    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
  }
}

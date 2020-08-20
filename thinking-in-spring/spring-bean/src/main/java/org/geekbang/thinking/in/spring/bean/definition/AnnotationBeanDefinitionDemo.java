package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Map;

//@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo<pubic> {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext =
        new AnnotationConfigApplicationContext();
    annotationConfigApplicationContext.register(Config.class);
    annotationConfigApplicationContext.refresh();

    Map<String, Config> configs = annotationConfigApplicationContext.getBeansOfType(Config.class);
    System.out.println("configs = " + configs);
    Map<String, User> users = annotationConfigApplicationContext.getBeansOfType(User.class);
    System.out.println("users = " + users);

    annotationConfigApplicationContext.close();
  }

  @Component
  public static class Config {
    @Bean(name = {"user", "user-alias"})
    public User user() {
      User user = new User();
      user.setId((long) 1);
      user.setName("james");
      return user;
    }
  }
}

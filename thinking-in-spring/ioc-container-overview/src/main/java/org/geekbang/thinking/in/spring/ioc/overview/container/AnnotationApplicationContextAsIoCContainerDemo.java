package org.geekbang.thinking.in.spring.ioc.overview.container;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class AnnotationApplicationContextAsIoCContainerDemo {
  public static void main(String[] args) {
    // create AnnotationConfigApplicationContext container
    AnnotationConfigApplicationContext annotationConfigApplicationContext =
        new AnnotationConfigApplicationContext();
    // Use AnnotationApplicationContextAsIoCContainerDemo class as configuration input
    annotationConfigApplicationContext.register(
        AnnotationApplicationContextAsIoCContainerDemo.class);
    annotationConfigApplicationContext.refresh();
    lookupByCollectionType(annotationConfigApplicationContext);
  }

  private static void lookupByCollectionType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
      System.out.println("Lookup by CollectionType: " + users);
    }
  }

  @Bean
  public User user() {
    User user = new User();
    user.setId((long) 1);
    user.setName("userName");
    return user;
  }
}

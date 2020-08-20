package org.geekbang.thinking.in.spring.ioc.overview.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/** Dependency lookup demo */
public class DependencyLookupDemo {
  public static void main(String[] args) {

    BeanFactory beanFactory =
        new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
    lookupByTypeInRealtime(beanFactory);
    lookupByCollectionType(beanFactory);
    lookupByAnnotation(beanFactory);
    lookupByIdInRealtime(beanFactory);
    lookupInLazy(beanFactory);
  }

  private static void lookupByAnnotation(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory){
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
      Map<String, User> superUsers = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
      System.out.println("DependencyLookupDemo.lookupByAnnotation: "+ superUsers);
    }
  }

  private static void lookupByCollectionType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory){
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
      Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
      System.out.println("Lookup by CollectionType: " + users);
    }
  }

  private static void lookupByTypeInRealtime(BeanFactory beanFactory) {
    User user = beanFactory.getBean(User.class);
    System.out.println("Lookup by type in realtime: " + user);
  }

  private static void lookupByIdInRealtime(BeanFactory beanFactory) {
    User user = (User) beanFactory.getBean("user");
    System.out.println("Lookup by Id in realtime: " + user);
  }

  private static void lookupInLazy(BeanFactory beanFactory) {
    ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
    User user = objectFactory.getObject();
    System.out.println("Lookup by Id in lazy: " + user);
  }
}

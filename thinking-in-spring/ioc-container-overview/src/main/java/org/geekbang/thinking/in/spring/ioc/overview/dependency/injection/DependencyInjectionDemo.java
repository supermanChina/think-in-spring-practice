package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.geekbang.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Dependency injection demo
 *
 * @author James
 */
public class DependencyInjectionDemo {
  public static void main(String[] args) {

    BeanFactory beanFactory =
        new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
    // 1st Bean source: User defined bean
    UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
    System.out.println("UserRepository.users:" + userRepository.getUsers());

    // UserRepositoty.beanFactory is set by dependency injection
    // 2nd Bean source: internal dependency
    System.out.println("userRepository.getBeanFactory(): " + userRepository.getBeanFactory());
    System.out.println("beanFactory: " + beanFactory);
    System.out.println(
        "beanFactory instanceof DefaultListableBeanFactory: "
            + (beanFactory instanceof DefaultListableBeanFactory));
    System.out.println(userRepository.getBeanFactory() == beanFactory);

    // Dependency lookup failed due to No qualifying bean of type BeanFactory
    // BeanFactory is not a normal bean.
    // System.out.println(beanFactory.getBean(BeanFactory.class));

    ObjectFactory userObjectFactory = userRepository.getObjectFactory();
    System.out.println(userObjectFactory.getObject());
    System.out.println(userObjectFactory.getObject() == beanFactory);

    // 3rd Bean source: container internal built bean
    Environment env = beanFactory.getBean(Environment.class);
    System.out.println("Get env bean = " + env);
  }
}

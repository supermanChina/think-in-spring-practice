package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAliasDemo {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext classPathXmlApplicationContext =
        new ClassPathXmlApplicationContext("classpath:/META-INF/beans-alias-context.xml");
    User userAlias = classPathXmlApplicationContext.getBean("user-alias", User.class);
    User user = classPathXmlApplicationContext.getBean("user", User.class);
    System.out.println("user == userAlias: " + (user == userAlias));
  }
}

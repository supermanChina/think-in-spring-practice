package org.geekbang.thinking.in.spring.ioc.overview.container;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryAsIoCContainerDemo {
  public static void main(String[] args) {
    // create BeanFactory container
    DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
    // Load beans from XML configuration
    XmlBeanDefinitionReader xmlBeanDefinitionReader =
        new XmlBeanDefinitionReader(defaultListableBeanFactory);

    // XML config file location
    String location = "classpath:/META-INF/dependency-lookup-context.xml";
    int beansCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
    System.out.println("beansCount = " + beansCount);

    lookupByCollectionType(defaultListableBeanFactory);
  }

  private static void lookupByCollectionType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory){
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
      Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
      System.out.println("Lookup by CollectionType: " + users);
    }
  }
}

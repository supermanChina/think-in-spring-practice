package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreationDemo {

  public static void main(String[] args) {
    // BeanDefinitionBuilder 构建
      BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
      beanDefinitionBuilder.addPropertyValue("id", 1).addPropertyValue("name", "james");
      AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
      beanDefinition.setLazyInit(true);

      // AbstractBeanDefinition 派生类 GenericBeanDefinition 构建
      GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
      MutablePropertyValues propertyValues = new MutablePropertyValues();
      propertyValues.add("id", 1).add("name", "james2");
      genericBeanDefinition.setPropertyValues(propertyValues);
  }
}

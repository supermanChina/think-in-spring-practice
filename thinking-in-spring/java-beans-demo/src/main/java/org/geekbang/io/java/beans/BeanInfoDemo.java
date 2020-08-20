package org.geekbang.io.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

public class BeanInfoDemo {

  public static void main(String[] args) throws IntrospectionException {
    BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
      Person personBean = new Person();
      Stream.of(beanInfo.getPropertyDescriptors())
        .forEach(
            propertyDescriptor -> {
              System.out.println(propertyDescriptor);

              // PropertyDescriptor allow add PropertyEditor
              // GUI -> text(String) -> PropertyType
              // name -> String
              // age -> Integer
              Class<?> propertyType = propertyDescriptor.getPropertyType();

              if ("age".equals(propertyDescriptor.getName())) {
                // String -> Integer
                //                  Integer.valueOf()
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                propertyDescriptor.createPropertyEditor(personBean);
              }
            });
  }

  static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
          Integer value = Integer.valueOf(text);
          setValue(value);
      }
  }
}

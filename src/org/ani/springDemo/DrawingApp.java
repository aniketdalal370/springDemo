package org.ani.springDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

    public static void main(String[] args) {

        //BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Shape shape = (Shape) applicationContext.getBean("circle");
        shape.draw();

        System.out.println(applicationContext.getMessage("greetings", null,
                "Default message", null));
    }
}

package edu.tampa.open_pet3;

import edu.tampa.open_pet3.repositories.mock.MockUserRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext config = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println(config.getBean(MockUserRepository.class));
//        System.out.println(Arrays.toString(config.getBeanDefinitionNames()));
//        config.close();
    }
}

package com.zyh.springbtest.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test1Application {

    public static void main (String[] args) {
        SpringApplication.run(Test1Application.class, args);
    }

    /*@Autowired
    private EntityManagerFactory entityManagerFactory;*/

    /*@Bean
    public SessionFactory getSessionFactory() {
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return entityManagerFactory.unwrap(SessionFactory.class);
    }*/
}

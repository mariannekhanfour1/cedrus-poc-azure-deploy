package com.tutorial.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.text.NumberFormat;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private ApplicationContext ctx; //manages the beans

//    @Autowired
//     works if we have only one instance of the type of the bean (autowiring by type)
//     if we have 2 instances of same type we have to add qualifier
//    NumberFormat nf;

    @Autowired
    @Qualifier("GermanCurrencyFormat") // we have 2 instances of same type
    NumberFormat nf2;


//    @Test
//    void DefaultCurrency() {
//        double amount = 123456.675;
//        System.out.println(nf.format(amount));
//    }

    @Test
    void germanCurrency() {
        double amount = 123456.675;
        System.out.println(nf2.format(amount));
        //or we can use the context and get it by searching by its name
        NumberFormat deutchNF=ctx.getBean("GermanCurrencyFormat",NumberFormat.class);
        System.out.println(nf2.format(amount));
    }


    @Test
    void contextLoads() {
        int count = ctx.getBeanDefinitionCount();
        System.out.println("count " + count);
        for (String name : ctx.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}

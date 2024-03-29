package com.dyonestrankers.springbasic;

import com.dyonestrankers.springbasic.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class HelloWorldConfiguration {

    /**
    * jika tidak menggunakan @Bean maka tidak dianggap sebagai bean
    */
    @Bean
    public Foo foo() {
        HelloWorldConfiguration.log.info("Membuat bean Foo");
        return new Foo();
    }

}
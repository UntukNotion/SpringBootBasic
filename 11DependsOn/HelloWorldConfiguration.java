package com.dyonestrankers.springbasic;

import com.dyonestrankers.springbasic.data.Bar;
import com.dyonestrankers.springbasic.data.Foo;
import com.dyonestrankers.springbasic.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    @DependsOn(value = {"bar"})
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public FooBar fooBar(Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }

}

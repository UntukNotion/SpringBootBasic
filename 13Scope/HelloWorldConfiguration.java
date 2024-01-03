package com.dyonestrankers.springbasic;

import com.dyonestrankers.springbasic.data.Bar;
import com.dyonestrankers.springbasic.data.Foo;
import com.dyonestrankers.springbasic.data.FooBar;
import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    @Scope("prototype")
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

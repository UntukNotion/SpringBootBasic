package com.dyonestrankers.springbasic;

import com.dyonestrankers.springbasic.data.Bar;
import com.dyonestrankers.springbasic.data.Foo;
import com.dyonestrankers.springbasic.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        this.context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    }

    @Test
    void testWithoutDependInject() {

        Foo foo = new Foo();
        Bar bar = new Bar();

        FooBar fooBar = new FooBar(foo, bar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }

    @Test
    void testWithDependInject() {

        Foo foo = this.context.getBean(Foo.class);
        Bar bar = this.context.getBean(Bar.class);
        FooBar fooBar = this.context.getBean(FooBar.class);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}
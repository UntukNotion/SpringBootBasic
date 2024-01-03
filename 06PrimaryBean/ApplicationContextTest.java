package com.dyonestrankers.springbasic;

import com.dyonestrankers.springbasic.data.Foo;
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
    void testPrimary() {

        Foo foo1 = this.context.getBean(Foo.class);
        Foo foo2 = this.context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);

    }
}
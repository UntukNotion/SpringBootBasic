# Application Context

ApplicationContext adalah sebuah interface representasi container IoC di Spring

ApplicationContext adalah inti dari Spring Framework

ApplicationContext banyak sekali class implementasinya, secara garis besar dibagi menjadi 2 jenis implementasi, XML dan Annotation

Pada versi Spring 3, XML masih menjadi pilihan utama, namun sekarang sudah banyak orang beralih dari XML ke Annotation, bahkan Spring Boot pun merekomendasikan menggunakan Annotation untuk membuat aplikasi Spring

[Dokumentasi](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html) 

# Configurasi

Untuk membuat ApplicationContext menggunakan Annotation, pertama kita bisa perlu membuat Configuration class

Configuration Class adalah sebuah class yang terdapat annotation @Configuration pada class tersebut

## HelloWorldConfiguration
```java
package com.dyonestrankers.springbasic;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

    // defaultnya akan membuat application context namun datanya kosong

}
```

# Membuat Application Context

Selanjutnya, setelah membuat Class Configuration, kita bisa menggunakan class AnnotationConfigApplicationContext untuk membuat Application Context

[Dokumentasi](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html) 

## ApplicationContextTest
```java
package com.dyonestrankers.springbasic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

    @Test
    void testApp() {

        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        Assertions.assertNotNull(context);

    }

}
```
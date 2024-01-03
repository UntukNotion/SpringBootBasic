# Bean

Saat sebuah object kita masukkan kedalam Spring Container IoC, maka kita sebut object tersebut adalah Bean

Secara default, bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan object yang sama. Kita juga bisa mengubahnya jika tidak ingin singleton, nanti akan kita bahas di materi tersendiri

# Membuat Bean

Untuk membuat bean, kita bisa membuat sebuah method di dalam class Configuration

Selanjutnya nama method tersebut akan menjadi nama bean nya, dan return object nya menjadi object bean nya

Method tersebut perlu kita tambahkan annotation @Bean, untuk menandakan bahwa itu adalah bean
Secara otomatis Spring akan mengeksekusi method tersebut, dan return value nya akan dijadikan object bean secara otomatis, dan disimpan di container IoC

## data/Foo.java
```java
package com.dyonestrankers.springbasic.data;

public class Foo {
}
```

## HelloWorldConfiguration.java
```diff
    package com.dyonestrankers.springbasic;

+   import com.dyonestrankers.springbasic.data.Foo;
+   import lombok.extern.slf4j.Slf4j;
+   import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

+   @Slf4j
    @Configuration
    public class HelloWorldConfiguration {

        /**
        * jika tidak menggunakan @Bean maka tidak dianggap sebagai bean
        */
+       @Bean
+       public Foo foo() {
+           log.info("Membuat bean Foo");
+           return new Foo();
        }

    }
```

# Mengakses Bean

Setelah kita membuat bean, secara otomatis semua object akan di-manage oleh Application Context

Untuk mengakses bean, kita bisa menggunakan method getBean milik Application Context

## ApplicationContextTest.java
```diff
    package com.dyonestrankers.springbasic;

+   import com.dyonestrankers.springbasic.data.Foo;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;

    public class ApplicationContextTest {

-       @Test
-       void testApp() {
-           ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
-           Assertions.assertNotNull(context);
-       }

+       @Test
+       void testCreateBean() {
+           ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

+           Assertions.assertNotNull(context);
+       }

+       @Test
+       void testGetBean() {
+           ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

+           Foo foo1 = context.getBean(Foo.class);
+           Foo foo2 = context.getBean(Foo.class);

+           Assertions.assertSame(foo1, foo2);
+       }

    }
```
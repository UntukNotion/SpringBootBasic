# Bean

Saat sebuah object kita masukkan kedalam Spring Container IoC, maka kita sebut object tersebut adalah Bean

Secara default, bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan object yang sama. Kita juga bisa mengubahnya jika tidak ingin singleton, nanti akan kita bahas di materi tersendiri

# Membuat Bean

Untuk membuat bean, kita bisa membuat sebuah method di dalam class Configuration

Selanjutnya nama method tersebut akan menjadi nama bean nya, dan return object nya menjadi object bean nya

Method tersebut perlu kita tambahkan annotation @Bean, untuk menandakan bahwa itu adalah bean
Secara otomatis Spring akan mengeksekusi method tersebut, dan return value nya akan dijadikan object bean secara otomatis, dan disimpan di container IoC

## HelloWorldConfiguration.java
```java diff
package com.dyonestrankers.springbasic;

import org.springframework.context.annotation.Configuration;

+ @Slf4j
@Configuration
public class HelloWorldConfiguration {

    // defaultnya akan membuat application context namun datanya kosong

}
```
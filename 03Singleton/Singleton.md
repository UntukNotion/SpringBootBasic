# Singleton

Singleton adalah salah satu Design Patterns untuk pembuatan objek, dimana sebuah object hanya dibuat satu kali saja

Dan ketika kita membutuhkan object tersebut, kita hanya akan menggunakan object yang sama

[Dokumentasi](https://refactoring.guru/design-patterns/singleton) 

# Membuat Singleton di Java

Ada banyak cara membuat singleton object di Java

Cara yang paling sering digunakan adalah membuat class yang berisikan static method untuk membuat object dirinya sendiri

Selanjutnya constructor nya dibuat private, agar tidak bisa diakses dari luar

Sehingga user terpaksa menggunakan method static tersebut ketika ingin membuat object nya

# Database.java
```java
package com.dyonestrankers.springbasic;

public class Database {

  private static Database database;

  public static Database getInstance(){
    if(database == null){
      database = new Database();
    }
    return database;
  }

  /**
   * karena di sini private, maka tidak bisa seperti ini
   * 
   * Database db = new Database();
   */
  private Database(){
  }

  /**
   * dan karena tidak bisa membuat object menggunakan kata kunci new
   * maka pembuatannya menggunakan method yang bersifat public static
   * yaitu getInstance(), sehingga pembuatannya seperti ini
   * 
   * Database db = Database.getInstance();
   */

}
```

# DatabaseTest.java
```java
package com.dyonestrankers.springbasic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

  @Test
  void testSingleton() {

    var database1 = Database.getInstance();
    var database2 = Database.getInstance();

    Assertions.assertSame(database1, database2);

  }
}
```
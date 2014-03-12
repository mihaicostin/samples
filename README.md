Samples
=======

Some basic code samples that help on brushing up on those enterprisy skill set :)

What I intend to cover:

Persistence
-----------
Using Spring 4 [http://spring.io/] and Hibernate 4.3.4 [http://hibernate.org/orm/]

* Spring with plain Hibernate.
  * Pros: You can write the DAOs using direcly hibernate and hql (can go as far as making the DAOs unaware of spring)  
  * Cons: You can write the DAOs using direcly hibernate - so it won't be easy to switch at some point with another orm.
* Spring with JPA and Hibernate as jpa provider
  * Pros: Write the DAOs using JPA (again, dao can be unaware of spring if that is required) in a way that is totally decoupled from the used provider.
  * Cons: Maybe if you need some ORM (hibernate in this case) specific and unique feature
* Spring Data JPA over JPA with Hibernate as provider.
  * Pros: You get some free functionality by using the provided repository interfaces and support for Querydsl 
  * Cons: Maybe you loose some of the clarity by adding yet another layer between your code and the db. 



Web
----
* Spring MVC

Extra
-----
* Java 8
* Spring & Scala

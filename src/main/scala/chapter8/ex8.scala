package chapter8

object ex8 extends App{

}

class Person(val name: String) {
  override def toString = s"${getClass.getName}[name=$name]"
}

class SecretAgent(codeName: String) extends Person(codeName) {
  override val name = "secret"
  override val toString = "secret"
}
/*
scala> import chapter8.{Person, SecretAgent}

scala> :javap -public Person
Compiled from "ex8.scala"
public class chapter8.Person {
  public java.lang.String name();
  public java.lang.String toString();
  public chapter8.Person(java.lang.String);
}

scala> :javap -public SecretAgent
Compiled from "ex8.scala"
public class chapter8.SecretAgent extends chapter8.Person {
  public java.lang.String name();
  public java.lang.String toString();
  public chapter8.SecretAgent(java.lang.String);
}
scala> :javap -private SecretAgent
Compiled from "ex8.scala"
public class chapter8.SecretAgent extends chapter8.Person {
  private final java.lang.String name;
  private final java.lang.String toString;
  public java.lang.String name();
  public java.lang.String toString();
  public chapter8.SecretAgent(java.lang.String);
}

scala> :javap -private Person
Compiled from "ex8.scala"
public class chapter8.Person {
  private final java.lang.String name;
  public java.lang.String name();
  public java.lang.String toString();
  public chapter8.Person(java.lang.String);
}
 */
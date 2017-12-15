/**
  * Class Person
  * @param name
  * @param id
  * @param email
  */
class Person(val name: String, val id: String, val email: String) {

  val this.name: String = name
  val this.id: String = id
  val this.email: String = email


  override def toString: String = {

    "Name:" + name + " Id:" + id + " Email:" + email
  }
}
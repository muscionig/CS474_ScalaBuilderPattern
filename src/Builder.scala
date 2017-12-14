import BuildeMy.{FALSE, PersonBuilder}

object BuildeMy {

  abstract class TRUE

  abstract class FALSE

  class Person(val name: String, val id: String, val email: String) {

    val this.name: String = name
    val this.id: String = id
    val this.email: String = email


    override def toString: String = {

      "Name:" + name + " Id:" + id + " Email:" + email
    }
  }

  class PersonBuilder[NAME, ID, EMAIL](val name: Option[String], val id: Option[String], val email: Option[String]) {

    def withName(name: String) = {

      new PersonBuilder[TRUE, ID, EMAIL](Some(name), id, email)
    }

    def withId(id: String) = {

      new PersonBuilder[NAME, TRUE, EMAIL](name, Some(id), email)
    }

    def withEmail(email: String) = {

      new PersonBuilder[NAME, ID, TRUE](name, id, Some(email))
    }
  }

  implicit def enableBuild(builder: PersonBuilder[TRUE, TRUE, TRUE]) = new {
    def build() = new Person(builder.name.get, builder.id.get, builder.email.get)
  }
}


  object Builder {

  def main(args: Array[String]) = {

    val builder = new PersonBuilder[FALSE,FALSE,FALSE](None,None,None)
    val me =  builder.withName("Guido").withId("652520943").withEmail("gmusci2@uic.edu").build()
    println("Building me:  " + me)
  }
}
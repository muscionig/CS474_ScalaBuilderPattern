import utils.PersonUnderBuilding

/**
  * Main class
  */
object Builder {

  object NormalPersonBuilder {
    def apply() = new NormalPersonBuilder[PersonUnderBuilding {}]
  }

  def main(args: Array[String]) = {

    println("START EXECUTION")

    //Building a normal person
    val me = NormalPersonBuilder().withName("Guido").withSSN("766556").withEmail("gmusci2@uic.edu").build
    println("\nBuilding me:  " + me)

    //Building a student
    val meAsStudent = NormalPersonBuilder().withName("Guido").withId("652520943").withEmail("gmusci2@uic.edu").withStudent.withLevel("Master").withGPA("1000").build
    println("\nBuilding me:  " + meAsStudent)

    //Building a professor
    val meAsProfessor = NormalPersonBuilder().withName("Guido").withId("652520943").withEmail("gmusci2@uic.edu").withProfessor.withDepartment("CS").build
    println("\nBuilding me:  " + meAsProfessor)

    println("\nEXECUTION END")
  }
}


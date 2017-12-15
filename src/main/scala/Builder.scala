import utils.PersonUnderBuilding

object Builder {

  object NormalPersonBuilder {
    def apply() = new NormalPersonBuilder[PersonUnderBuilding {}]
  }

  def main(args: Array[String]) = {

    val me = NormalPersonBuilder().withName("Guido").withId("652520943").withEmail("gmusci2@uic.edu").build
    println("Building me:  " + me)
    val meAsStudent = NormalPersonBuilder().withName("Guido").withId("652520943").withEmail("gmusci2@uic.edu").withStudent.withLevel("Master").build("Ciao")
    println("Building me:  " + meAsStudent)
  }
}


import utils.{PersonUnderBuilding, TRUE}

/**
  * This is the normal person builder, it allows the building of a normal person: Class Person
  * @tparam Building
  */
class NormalPersonBuilder[Building <: PersonUnderBuilding]() {

  self =>
  private var name: Option[String] = None
  private var id: Option[String] = None
  private var email: Option[String] = None

  def normalPersonBuilder[BuildingNew <: PersonUnderBuilding] = this.asInstanceOf[NormalPersonBuilder[BuildingNew]]


  def withName(name: String) = {

    self.name = Some(name)
    normalPersonBuilder[Building { type id = TRUE }]
  }

  def withId(id: String) = {

    self.id = Some(id)
    normalPersonBuilder[Building { type name = TRUE }]
  }

  def withEmail(email: String) = {

    self.email = Some(email)
    normalPersonBuilder[Building { type email = TRUE }]
  }

  def withStudent(implicit ev1: Building#id =:= TRUE, ev2: Building#name =:= TRUE, ev3: Building#email =:= TRUE ): StudentBuilder[Building] = {

    new StudentBuilder[Building](name.get, id.get, email.get)
  }

  def build(implicit ev1: Building#id =:= TRUE, ev2: Building#name =:= TRUE, ev3: Building#email =:= TRUE): Person = {

    new Person(name.get, id.get, email.get)
  }
}


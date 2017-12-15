import utils.{FALSE, PersonUnderBuilding, TRUE}

/**
  * This is the normal person builder, it allows the building of a normal person: Class Person
  * @tparam Building
  */
class NormalPersonBuilder[Building <: PersonUnderBuilding]() {

  self =>
  private var name: Option[String] = None
//  private var id: Option[String] = None
//  private var ssn: Option[String] = None
  private var identificationCode: Option[String] = None
  private var email: Option[String] = None


  def normalPersonBuilder[BuildingNew <: PersonUnderBuilding] = this.asInstanceOf[NormalPersonBuilder[BuildingNew]]


  def withName(name: String) = {

    self.name = Some(name)
    normalPersonBuilder[Building { type name = TRUE
                                   type ssn = FALSE
                                   type id = FALSE}]
  }

  def withId(id: String)(implicit value1: Building#ssn =:= FALSE) = {

    self.identificationCode = Some(id)
    normalPersonBuilder[Building { type id = TRUE
                                   type identification = TRUE}]
  }

  def withEmail(email: String) = {

    import java.util.regex.Pattern
    val regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
    val matcher = regex.matcher(email)
    if(!matcher.find()){throw new IllegalArgumentException("Not a valid email address")}
    self.email = Some(email)
    normalPersonBuilder[Building { type email = TRUE }]
  }

  def withSSN(ssn: String)(implicit value1: Building#id =:= FALSE) = {

    self.identificationCode = Some(ssn)
    normalPersonBuilder[Building { type ssn = TRUE
                                   type identification = TRUE}]
  }

  def withStudent(implicit value1: Building#name =:= TRUE,value2: Building#identification =:= TRUE  ,  value3: Building#email =:= TRUE): StudentBuilder[Building] = {

    new StudentBuilder[Building](name.get, identificationCode.get, email.get)
  }

  def withProfessor(implicit value1: Building#name =:= TRUE,value2: Building#identification =:= TRUE  ,  value3: Building#email =:= TRUE): ProfessorBuilder[Building] = {

    new ProfessorBuilder[Building](name.get, identificationCode.get, email.get)
  }

  def build(implicit value1: Building#name =:= TRUE,value2: Building#identification =:= TRUE  ,  value3: Building#email =:= TRUE): Person = {

    new Person(name.get, identificationCode.get, email.get)
  }
}


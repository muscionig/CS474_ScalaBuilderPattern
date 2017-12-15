import utils.{PersonUnderBuilding, TRUE}

/**
  * This class is the professor builder it allows the building of the professor starting from a person
  * @param professorName
  * @param professorId
  * @param professorEmail
  * @tparam Building
  */
class ProfessorBuilder [Building <: PersonUnderBuilding](val professorName: String, val professorId: String, val professorEmail: String) extends {

  self =>
  private var name: String = professorName
  private var id: String = professorId
  private var email: String = professorEmail
  private var department: Option[String] = None
  private var office: Option[String] = None

  def professorBuilder[BuildingNew <: PersonUnderBuilding] = this.asInstanceOf[ProfessorBuilder[BuildingNew]]

  def withDepartment(department: String) = {

    self.department = Some(department)
    professorBuilder[Building { type department = TRUE}]
  }

  def withOffice(office: String)(implicit value1: Building#department =:= TRUE) = {

    self.office = Some(office)
    professorBuilder[Building]
  }

  def build(implicit value1: Building#id =:= TRUE, value2: Building#name =:= TRUE, value3: Building#email =:= TRUE, value4: Building#department =:= TRUE): Professor = {

    new Professor(name, id, email, department.get, office)
  }
}

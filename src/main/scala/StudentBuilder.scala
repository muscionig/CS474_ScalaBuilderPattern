import utils.{PersonUnderBuilding, TRUE}

/**
  * This class is the student builder it allows the building of the student starting from a person
  * @param studentName
  * @param studenId
  * @param studentEmail
  * @tparam Building
  */
class StudentBuilder[Building <: PersonUnderBuilding](val studentName: String, val studenId: String, val studentEmail: String) extends {

  self =>
  private var name: String = studentName
  private var id: String = studenId
  private var email: String = studentEmail
  private var level: Option[String] = None
  private var gpa: Option[String] = None

  def studentBuilder[BuildingNew <: PersonUnderBuilding] = this.asInstanceOf[StudentBuilder[BuildingNew]]

  def withLevel(level: String) = {

    self.level = Some(level)
    studentBuilder[Building { type level = TRUE}]
  }

  def withGPA(gpa: String)(implicit value1: Building#level =:= TRUE) = {

    self.gpa = Some(gpa)
    studentBuilder[Building]
  }

  def build(implicit value1: Building#id =:= TRUE, value2: Building#name =:= TRUE, value3: Building#email =:= TRUE, value4: Building#level =:= TRUE): Student = {

    new Student(name, id, email, level.get, gpa)
  }
}

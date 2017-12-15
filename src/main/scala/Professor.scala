/**
  * Class Professor, it extends the Person class as requires it to complete the Professor creation
  *
  * @param studentName
  * @param studenId
  * @param studentEmail
  * @param department
  * @param office
  */
class Professor(val studentName: String, val studenId: String, val studentEmail: String, val department: String, val office: Option[String])
  extends Person(studentName, studenId, studentEmail) {

  val this.department: String = department
  val this.office: Option[String] = office

  /**
    * Method to ensure that the Optional parameter is handled correctly
    *
    * @param value
    * @return
    */
  private[this] def getOrDefault(value: Option[String]): String = {

    value match {
      case Some(value) => value
      case None => " Not inserted"
    }
  }

  override def toString: String = {
    "[PROFESSOR] \n" + super.toString + "" +
      "\nDepartment: " + this.department + "\nOffice: " + getOrDefault(office)
  }
}

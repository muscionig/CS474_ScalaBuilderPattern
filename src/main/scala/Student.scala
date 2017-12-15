/**
  * Class Student, it extends the Person class as requires it to complete the Student creation
  * @param studentName
  * @param studenId
  * @param studentEmail
  * @param level
  * @param gpa
  */
class Student(val studentName: String, val studenId: String, val studentEmail: String, val level: String, val gpa: Option[String])
  extends Person(studentName, studenId, studentEmail){

  val this.level: String = level
  val this.gpa: Option[String] = gpa


  override def toString: String = {
    "[STUDENT] \n" + super.toString + "\n" +
    "Level:" + this.level + " gpa:" + gpa
  }

}

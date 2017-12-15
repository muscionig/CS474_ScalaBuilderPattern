package utils

/**
  * Boolean values
  */
sealed trait Value
trait TRUE extends Value
trait FALSE extends Value

/**
  * Type system for the builder pattern
  */
sealed trait PersonUnderBuilding {

  //Person
  type name <: Value
  //id and ssn are mutually exclusive
  type id <: Value
  type ssn <: Value
  type email <: Value
  type identification <: Value

  //Student
  type level <: Value

  //Professor
  type department <: Value

}

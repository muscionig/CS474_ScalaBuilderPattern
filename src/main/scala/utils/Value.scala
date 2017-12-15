package utils

sealed trait Value
trait TRUE extends Value
trait FALSE extends Value

sealed trait PersonUnderBuilding {
  type name <: Value
  type id <: Value
  type email <: Value
  type level <: Value
}

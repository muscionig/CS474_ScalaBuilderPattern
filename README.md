# CS474_ScalaBuilderPattern (Guido Muscioni)

This is the repository for the optional homework of the CS474 course.

## Implementation

I have implemented the builder pattern for generating people in a university environment.

There are three main types:

* Person: a normal person with only a name, an identification and an email
* Student: a student with a level and a GPA
* Professor: a professor with a department and an office

## Main features

The homework is implemented using scala.

During the implementation I have decided to make the attributes of a normal person REQUIRED, thus the program will not compile if someone wants to generate a Person without all the three attributes.

The Student is builded with a method withStudent and the Professor with a method withProfessor, both the methods requires that the Person is fully created.

For what concerns Student and Professor Builder, there is a priority for the attribute order: the Student requires the level before the GPA and the Professor requires the department before the office. Finally both office and GPA are optional, if these attributes are not setted the program will return a not inserted string inside the correct field.

The Person class, as it is mentioned before requires all the three attributes, however the identification can be choosen between SSN and ID (univeristy ID). Furthermore these two attributes are mutually exclusive and so if an SSN is setted, the ID cannot be setted, the code automatically checks for this assertion.

The email attribute is verified to be in the correct format with a regular expression, if the email format is not correct, the code will throw an IllegalArgumentException, notifying that the email format is not correct. That implementation is inside the NormalPersonBuilder.

## Instructions

The program can be runned using SBT.

to compile the program please type:

    sbt compile

to run the program please type:

    sbt run

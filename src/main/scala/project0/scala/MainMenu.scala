package project0.scala

import java.sql.{Connection, DriverManager}
import java.io.File
import java.io.FileNotFoundException
import java.util.{InputMismatchException, Scanner}
import java.sql.{Connection, DriverManager, SQLException}

object MainMenu {
  val url = "jdbc:mysql://localhost:3306/bazaar_findings"
  val username = "root"
  val password = "M0ch@-Life13"
  val driver = "com.mysql.jdbc.Driver"
  val scanner = new Scanner(System.in)
  val trans: Array[String] = Array()
  val connection = DriverManager.getConnection(url, username, password)

  def selectAllWeapons(): Unit = {
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM combat_&_defense;")
    println(resultSet)
    while (resultSet.next()) {
      println(resultSet.getString(1) + "; " + resultSet.getString(2) + "; " + resultSet.getString(3));
      resultSet.getString(4)
    }
  }

  def selectAllRecoveries(): Unit = {
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM magic_&_health_recovery;")
    println(resultSet)
    while (resultSet.next()) {
      println(resultSet.getString(1) + "; " + resultSet.getString(2) + "; " + resultSet.getString(3));
      resultSet.getString(4)
    }
  }

  def main(args: Array[String]): Unit = {
    Console.println("Welcome to Bazaar Findings! Ordinary, or bizarre? What will you find to aid you on your quest?")

    println("What would you like to shop for?")

    val x = scala.io.StdIn.readLine()
    var yes = 1
    var no = 2

    if (x.equals("Combat & Defense")) {
      println("It's dangerous to go alone! Take this!")

      println("Would you like to buy this item?")
      if (x.equals(1)) {
        println("Thank you for your business!")
      }
      else {
        if (x.equals(2)) {
          println("Come again soon!")
        }
      }
    }
    if (x.equals("Health Recovery")) {
      println("Our potions will have you feeling better in no time at all!")
      println("Would you like to buy this item?")
      if (x.equals(1)) {
        println("Thank you for your business!")
      }
      else {
        if (x.equals(2)) {
          println("Come again soon!")
        }
      }
    }
    else {
      if (x.equals("No thanks.")) {
        println("Come again soon!")
      }
      if (x.equals("I'm here to rob you!")) {
        println("I wouldn't do that if I were you. You heard what happened to that guy from Hyrule.")
      }
    }
  }
}




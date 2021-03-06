package project0.scala

import java.sql.{Connection, DriverManager}
import java.io.File
import java.io.FileNotFoundException
import java.util.{InputMismatchException, Scanner}
import java.sql.{Connection, DriverManager, SQLException}
import scala.io.StdIn._
import scala.sys.exit


object MainMenu {
  val url = "jdbc:mysql://localhost:3306/bazaar_findings"
  val username = "root"
  val password = "M0ch@-Life13"
  val driver = "com.mysql.jdbc.Driver"
  val scanner = new Scanner(System.in)
  val trans: Array[String] = Array()
  val connection = DriverManager.getConnection(url, username, password)

  /*def selectAllWeapons(): Unit = {
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM combat;")
    println(resultSet)
    while (resultSet.next()) {
      println(resultSet.getString(1) + "; " + resultSet.getString(2) + "; " + resultSet.getString(3));
      resultSet.getString(4)
    }
  }*/

  /*def selectAllRecoveries(): Unit = {
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM recovery;")
    println(resultSet)
    while (resultSet.next()) {
      println(resultSet.getString(1) + "; " + resultSet.getString(2) + "; " + resultSet.getString(3));
      resultSet.getString(4)
    }
  }*/

  def main(args: Array[String]): Unit = {
    Console.println("Welcome to Bazaar Findings! Ordinary, or bizarre? What will you find to aid you on your quest?")
    val box = 1
    while(box == 1){
      println("What would you like to shop for?")
      println("\nPlease select a catagory.")
      println("1. Combat & Defense")
      println("2. Health Recovery")
      println("3. I'm here to sell.")
      println("4. No thanks.")


      val x = scala.io.StdIn.readLine()
      val myBoolean = true;

      if (x.equals("1")) {
        println("It's dangerous to go alone! Take this!")
        val statement = connection.createStatement()
        val result = statement.executeQuery("SELECT * FROM combat")
        while(result.next()) {
          System.out.print(result.getString("combat_id"))
          print(" ")
          System.out.println(result.getString("name"))
        }


        println("Which item would you like to buy? Enter ID number.")
        val input = scala.io.StdIn.readLine()
        println("Would you like to buy this item?")
        val confirm = scala.io.StdIn.readLine()
        if (confirm.equals("Yes") || confirm.equals("yes")) {
          println("Thank you for your business!")
          val statement = connection.createStatement()
          val result = statement.executeUpdate(
            s"""
               |INSERT INTO player_inventory(combat_id, Item_Name)
               |SELECT combat_id, name
               |FROM combat
               |WHERE combat_id = $input
               |""".stripMargin)
        }
        else {
          print("Come again soon!")
        }
      }

      else if (x.equals("2")) {
        println("Our potions will have you feeling better in no time at all!")
        val statement = connection.createStatement()
        val result = statement.executeQuery("SELECT * FROM recovery")
        while(result.next()) {
          System.out.print(result.getString("recover_id"))
          print(" ")
          System.out.println(result.getString("name"))
        }


        println("Which item would you like to buy? Enter ID number.")
        val input = scala.io.StdIn.readLine()
        println("Would you like to buy this item?")
        val confirm = scala.io.StdIn.readLine()
        if (confirm.equals("Yes") || confirm.equals("yes")) {
          print("Thank you for your business!")
          val statement = connection.createStatement()
          val result = statement.executeUpdate(
            s"""
               |INSERT INTO player_inventory(recover_id, Item_Name)
               |SELECT recover_id, name
               |FROM recovery
               |WHERE recover_id = $input
               |""".stripMargin)
        }
      }
      else if (x.equals("3")) {
        println("Certainly! What do you have?")
        val statement = connection.createStatement() //create query statement

        val result = statement.executeQuery("SELECT * FROM player_inventory") //the actual query showing you information

        while(result.next()) { //this is what displays the transaction
          System.out.print(result.getString("recover_id"))
          print("\t")
          System.out.print(result.getString("combat_id"))
          print("\t")
          System.out.println(result.getString("Item_Name"))
        }
        val input = scala.io.StdIn.readLine() //reads next line the user inputs
        println("So, you'd like to sell this?")
        val confirm = scala.io.StdIn.readLine()
        if (confirm.equals("Yes") || confirm.equals("yes")) { //$ is how you enter variables (e.g. input) into strings
          val delete = statement.executeUpdate(
            s"""
              |DELETE FROM player_inventory
              |WHERE recover_id = $input or combat_id = $input
              |""".stripMargin)
          println("Thank you for selling here!")
        }
      }
      else {
        print("Come again soon!")
        exit
      }
    }
  }


  }







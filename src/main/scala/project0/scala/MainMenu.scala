package project0.scala
import java.sql.{Connection, DriverManager}
import org.apache.spark.sql.execution.SQLExecution
import java.sql.DriverManager
import java.sql.Connection


object MainMenu {
  def main(args: Array[String]): Unit = {
    val call = dbConn()
    Console.println("Welcome to Bazaar Findings! Ordinary, or bizarre? What will you find to aid you on your quest?")

    print("What would you like to shop for?")

    val x = scala.io.StdIn.readLine()

    if (x.equals("Weapons")) {
      println("It's dangerous to go alone! Take this!")
    }
    else {
      if (x.equals("Health Recovery")) {
        println("Our potions will have you feeling better in no time at all!")
      }
      else {
        if (x.equals("No thanks.")) {
          println("Come again soon!")
        }
        else {
          if (x.equals("I'm here to rob you!")) {
            println("I wouldn't do that if I were you. You heard what happened to that guy from Hyrule.")
          }
        }
      }
    }
  }

  def dbConn(): Connection = {
    val url = "jdbc:mysql://localhost:3306/bazaar_findings"
    val username = "root"
    val password = "M0ch@-Life13"
    val driver = "com.mysql.jdbc.Driver"
    var connection:Connection = null

    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url,username,password)
      println("Connected to Database")
    } catch {
      case e:Throwable => e.printStackTrace
    }


    println("Successfully connected to " + connection)
    connection
  }
}

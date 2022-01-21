package project0.scala
import scala.Console.println
import java.sql.{Connection, DriverManager}
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine


object MainMenu {
  def main(args: Array[String]): Unit = {
    Console.println("Welcome to Bazaar Findings! Ordinary, or bizarre? What will you find to aid you on your quest?")

    val con = dbConn()

  }
  def dbConn(): Connection = {
    val url = "jdbc:mysql://localhost.3306/bazaar_findings"
    val username = "root"
    val password = "M0ch@-Life13"
    val driver = "com.mysql.jdbc.Driver"
    val connection = DriverManager.getConnection(url, username, password)
    println("Successfully connected to..." + connection)
    connection
  }
}

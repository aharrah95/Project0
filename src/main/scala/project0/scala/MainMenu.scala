package project0.scala
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import java.util.Scanner

object MainMenu {
  def main(args: Array[String]): Unit = {
    Console.println("Welcome to Bazaar Findings! Ordinary, or bizarre? What will you find to aid you on your quest?")

    print("What would you like to shop for?")

    val x=scala.io.StdIn.readLine()

    if (x.equals("Weapons")) {
      println("It's dangerous to go alone! Take this!")
    }
    else{
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
}

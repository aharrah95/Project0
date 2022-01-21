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
      println("Feast your eyes, young adventurer! Arm yourself to the teeth!")
    }
    else{
      if (x.equals("Health Recovery")) {
        println("Our potions will have you feeling better in no time at all!")
      }
      else {
        if (x.equals("No thanks.")) {
          println("Come again soon!")
        }
      }
    }
  }
}

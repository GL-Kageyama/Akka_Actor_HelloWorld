# Akka Actor HelloWorld

## Akka
Akka is a free and open-source toolkit and runtime simplifying the construction of concurrent and distributed applications on the JVM.   

## Actor
An actor is a lightweight process with four operations: create, send, come, and supervise.  
The actors send messages to each other and process asynchronously.  
　
## Code
```Scala
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}

// Messages sent to actors
final case class Hello(name: String)

// Define actor behavior
object PrintHello {

    def apply(): Behavior[Hello] = Behaviors.receiveMessage { message =>
        println(s"Hello ${message.name} !")
        Behaviors.same
    }
}

object Main extends App {

    val behavior: Behavior[Hello] = PrintHello()

    // Creating actor
    val printHelloActor: ActorSystem[Hello] = ActorSystem(behavior, name = "PrintActor")

    // Send message to actor
    printHelloActor ! Hello("World")
    printHelloActor ! Hello("Scala")
    printHelloActor ! Hello("Akka")
}
```

## Output Sample
// $ cd hello-world/  
// $ sbt  
// ...  
// $ ~run  
// ...  
// Hello World !  
// Hello Scala !  
// Hello Akka !  

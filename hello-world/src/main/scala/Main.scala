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


// ===================================
//           Output Sample
// ===================================
// $ cd hello-world 
// $ sbt
// [info] welcome to sbt 1.5.5 (Homebrew Java 11.0.12)
// [info] loading global plugins from /Users/GL-Kageyama/.sbt/1.0/plugins
// [info] loading project definition from /Users/GL-Kageyama/Desktop/Scala/ActorSample/hello-world/project
// [info] loading settings for project hello-world from build.sbt ...
// [info] set current project to hello-akka (in build file:/Users/GL-Kageyama/Desktop/Scala/ActorSample/hello-world/)
// [info] sbt server started at local:///Users/GL-Kageyama/.sbt/1.0/server/b70794d799a5b96a5f66/sock
// [info] started sbt server
// sbt:hello-akka> ~run
// [info] compiling 1 Scala source to /Users/GL-Kageyama/Desktop/Scala/ActorSample/hello-world/target/scala-2.13/classes ...
// [info] running Main 
// SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
// SLF4J: Defaulting to no-operation (NOP) logger implementation
// SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
// Hello World !
// Hello Scala !
// Hello Akka !

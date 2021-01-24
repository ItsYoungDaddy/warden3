package io.github.wine.warden.load

import io.github.wine.warden.Warden
import java.lang.instrument.Instrumentation
import java.lang.instrument.ClassFileTransformer

/**
 * After the JVM has initialized each agent's premain method is invoked
 * in order, after each premain has finished the real programs main
 * method is invoked. This allows us to access the [Instrumentation]
 * from the JVM which lets us add any finite amount of [ClassFileTransformer] instances
 * that has the ability to modify classes while they're being loaded into the classpath.
 */
fun premain(arguments: String?, instrumentation: Instrumentation) {
    println("WardenTransformer#premain")

    Warden

    instrumentation.addTransformer(Transformer())
}

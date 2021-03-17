# ClassWrapperMC
A simple wrapper to help launching Minecraft LaunchWrapper on JRE9 and later.

## Use it
- This library is used by PojavLauncher v3.

## A note
- There is a trick that will fix `ClassLoader` casting problem on Java 9+:
set the `java.system.class.loader` property on JVM arguments that point to a `URLClassLoader` extended class.

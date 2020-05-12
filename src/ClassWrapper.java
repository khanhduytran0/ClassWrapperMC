import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.reflect.*;

public class ClassWrapper
{
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("ClassWrapper v1.0, helper for launching Minecraft LaunchWrapper on Java 9.");

		String classPath = args[0];
		
		String mainClassStr = args[1];
		List<String> mainArgs = new ArrayList<String>(Arrays.asList(args));
		// Remove mainClass
		mainArgs.remove(0);
		// Remove classpath
		mainArgs.remove(1);
		
		List<URL> classPathList = new ArrayList<URL>();
		for (String perLib : classPath.split(":")) {
			if (!perLib.isEmpty()) {
				classPathList.add(new File(perLib).toURI().toURL());
			}
		}
		
		URLClassLoader loader = new URLClassLoader(classPathList.toArray(new URL[0]), ClassLoader.getSystemClassLoader());
		Class mainClass = loader.loadClass(mainClassStr);
		Method mainMethod = mainClass.getDeclaredMethod("main", String[].class);
		mainMethod.invoke(null, new Object[]{mainArgs.toArray(new String[0])});
	}
}

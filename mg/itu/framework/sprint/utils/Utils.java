package mg.itu.framework.sprint.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;

public class Utils {
    public static String getFileName(String fileName, String extension) {
        return fileName.substring(0, (fileName.length() - extension.length()) - 1);
    }
    
    public static ArrayList<Class<?>> getClasses(String packageName) throws ClassNotFoundException, IOException {
        ArrayList<Class<?>> classes = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        URL resource = classLoader.getResource(path);

        if (resource == null) {
            return classes;
        }
        File packageDirectory = new File(resource.getFile().replace("%20", " "));
        
        for (File file : packageDirectory.listFiles()) {
            if (file.isDirectory()) {
                classes.addAll(Utils.getClasses(packageName + "." + file.getName()));
            } else {
                String className = packageName + "." + Utils.getFileName(file.getName(), "class");
                classes.add(Class.forName(className));
            }
        }
        
        return classes;
    }

    public static ArrayList<Method> getClassMethod(Class<?> classes) throws Exception {
        ArrayList<Method> result = new ArrayList<Method>();
        Method[] declaredMethods = classes.getDeclaredMethods();
        for (Method method : declaredMethods) {
            result.add(method);
        }
        return result;
    }

    public static Object executeSimpleMethod(Object obj, String methodName) throws Exception {
        return obj.getClass().getMethod(methodName).invoke(obj);
    }
}

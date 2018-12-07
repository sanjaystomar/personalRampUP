package org.personal.rampup.classLoader;

import org.personal.rampup.customloaded.GinnyPig;

import java.lang.reflect.Method;

public class TestCustomClassLoader {
    public static void main(String args[]) throws Exception {
        String progClass = args[0];
        String progArgs[] = new String[args.length - 1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);

        CustomLoader ccl = new CustomLoader();
        Class clas = ccl.loadClass(progClass);
        Method main = clas.getMethod("toString");
        main.invoke(GinnyPig.class, null);

        System.out.println(GinnyPig.class.getClassLoader());

        Class cls = Class.forName("org.personal.rampup.customloaded.GinnyPig", true, new CustomLoader());

        System.out.println(cls.getClassLoader()); //.getParent().getParent());
    }

}


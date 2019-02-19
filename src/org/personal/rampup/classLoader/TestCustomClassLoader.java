package org.personal.rampup.classLoader;

import org.personal.rampup.customloaded.GinnyPig;

import java.lang.reflect.Method;
import java.security.SecureClassLoader;

public class TestCustomClassLoader {
    public static void main(String[] args) throws Exception {
        String progClass = args[0];
        CustomLoader ccl = new CustomLoader();
        Class clas = ccl.loadClass(progClass);
        System.out.println(clas.getClassLoader().getParent().getParent().getParent());

//        Class cls = Class.forName("org.personal.rampup.customloaded.GinnyPig", true, new CustomLoader());
//        System.out.println(cls.getClassLoader()); //.getParent().getParent());
    }

}


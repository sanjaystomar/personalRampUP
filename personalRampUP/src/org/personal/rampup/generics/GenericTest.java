package org.personal.rampup.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GenericTest {

    public static void main(String[] args) {
        ParentClass parentClass = new ChildClass();
        parentClass.modifyParentAttribute("MODIFY");
        System.out.println(parentClass.parentAttribute);
        try {
            Class clas = Class.forName("org.personal.rampup.generics.ChildClass");
            System.out.println(clas.getClassLoader().getParent().getParent());
            Method[] metholdList = clas.getMethods();
            for (Method m : metholdList) {
//                System.out.println(m);
                if (m.isBridge()) {
//                    ChildClass refInstance = (ChildClass) clas.newInstance();   || Object on which method is been called can be provided this or with new operator
                    m.invoke(new ChildClass(), "sanjay");
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}

class ParentClass<T> {
    public T parentAttribute;

    public void modifyParentAttribute(T modifyValue) {
        this.parentAttribute = modifyValue;
    }
}


class ChildClass extends ParentClass<String> {
    public void modifyParentAttribute(String modifyString) {
        super.modifyParentAttribute(modifyString);
        System.out.println(modifyString);
    }
}

package com.hqyj.mc.Test.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest04 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
         /*
        3. 获取成员方法们：
			* Method[] getMethods()
			* Method getMethod(String name, 类<?>... parameterTypes)

			* Method[] getDeclaredMethods()
			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         */
        Class<Person> personClass = Person.class;
        Method eat = personClass.getMethod("eat");
        Person p = new Person();
        eat.invoke(p);

        Method eat1 = personClass.getMethod("eat", String.class);
        eat1.invoke(p,"榴莲");

        Method[] method = personClass.getMethods();
        for (Method method1 : method) {
            System.out.println(method1);
            System.out.println(method1.getName());
        }
        System.out.println(personClass.getName());
    }
}

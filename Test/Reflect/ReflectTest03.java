package com.hqyj.mc.Test.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest03 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
         /*
        	2. 获取构造方法们
			* Constructor<?>[] getConstructors()
			* Constructor<T> getConstructor(类<?>... parameterTypes)
			* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
			* Constructor<?>[] getDeclaredConstructors()
         */
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        Person person = constructor.newInstance("zhang", 20);
        System.out.println(person);

        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor1 : constructors) {
            System.out.println(constructor1);
        }

        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class,int.class);
        System.out.println(declaredConstructor);
        Person person1 = declaredConstructor.newInstance("zhang", 20);
        System.out.println(person1);

        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor1 : declaredConstructors) {
            System.out.println(declaredConstructor1);
        }
    }
}

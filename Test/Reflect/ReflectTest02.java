package com.hqyj.mc.Test.Reflect;

import java.lang.reflect.Field;

/*
            1. 获取成员变量们
			* Field[] getFields() ：获取所有public修饰的成员变量
			* Field getField(String name)   获取指定名称的 public修饰的成员变量
			* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
			* Field getDeclaredField(String name)获取所有的成员变量，不考虑修饰符
         */
public class ReflectTest02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Person> Personclass = Person.class;

        Field[] fields = Personclass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field a = Personclass.getField("a");

        Person p = new Person();
        Object o = a.get(p);
        System.out.println(o);
        a.set(p,"zhang");
        System.out.println(a.get(p));

        Field[] f = Personclass.getDeclaredFields();
        for (Field field : f) {
            System.out.println(field);
        }

        Field a1 = Personclass.getDeclaredField("b");


        //忽略访问权限修饰符的安全检查
        a1.setAccessible(true);
        Object o1 = a1.get(p);
        System.out.println(o1);
    }
}

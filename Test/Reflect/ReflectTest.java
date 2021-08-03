package com.hqyj.mc.Test.Reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
* 案例：
	* 需求：写一个"框架"，不能改变该类的任何代码的前提下，
	* 可以帮我们创建任意类的对象，并且执行其中任意方法
		* 实现：
			1. 配置文件
			2. 反射
		* 步骤：
			1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
			2. 在程序中加载读取配置文件
			3. 使用反射技术来加载类文件进内存
			4. 创建对象
			5. 执行方法
 */
public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1. 在程序中加载读取配置文件
        //1.1.创建Properties对象
        Properties pro = new Properties();
        //1.2加载配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //3.使用反射技术来加载类文件进内存
        Class<?> aClass = Class.forName(className);
        //4.创建对象
        Object o = aClass.newInstance();

        //5. 执行方法
        Method method = aClass.getMethod(methodName);
        method.invoke(o);
    }
}

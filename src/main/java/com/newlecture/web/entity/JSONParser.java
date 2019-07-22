package com.newlecture.web.entity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JSONParser {

	public static String toJSON(Object object) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
	
		Class<?> clazz = object.getClass();
		
		Field[] fields = object.getClass().getDeclaredFields();
		//Method method = clazz.getDeclaredMethod(name, parameterTypes);
		Method[] methods =clazz.getDeclaredMethods();
		
		StringBuilder json = new StringBuilder();
		json.append("{");
		for (int i = 0; i < fields.length; i++) {
			
			String name = fields[i].getName();
			String geterName= "get"
								+Character.toUpperCase(name.charAt(0))
								+name.substring(1);
			
			Method method = clazz.getDeclaredMethod(geterName, new Class[] {});
			String value = String.valueOf(method.invoke(object));
			
			json.append(String.format("\"%s\":\"%s\"", name, value));
			if(i != fields.length-1)
				json.append(",");
		}
		json.append("}");
		return json.toString();

	}

}

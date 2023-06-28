package com.project.Generator.fireline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

import com.project.Generator.base.FeedData;
import com.project.Generator.interfaces.StartTask;

public class Factory implements StartTask {

	@Override
	public void go(FeedData feedData) {
		try {
			File file = new File(String.format(feedData.getDirectory() + "%sFactory.java", feedData.getFileName()));

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String str = String.format(
				    "public class %1$sFactory {\r\n"
				    + "	\r\n"
				    + "	private %1$sFactory () {}\r\n"
				    + "	\r\n"
				    + "	public static %1$sVO convertToVO(%1$sEntity entity) {\r\n"
				    + "		\r\n"
				    + "		return %1$sVO.builder()\n", feedData.getFileName());
			writer.append(str);
			
			Field[] allFields = feedData.getRequestModel().getDeclaredFields();
			Arrays.stream(allFields).forEach(field -> {
				try {
					writer.append(".");
					writer.append(field.getName());
					writer.append("(entity.get");
					writer.append(Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1));
					writer.append("())\n");
				} catch (IOException i) {
					i.printStackTrace();
				}
			});
			
			str = String.format(""
				    + ".build();\r\n"
				    + "}\r\n"
				    + "\r\n"
				    + "public static %1$sEntity convertToEntity(%1$sVO viewObject) {\r\n"
				    + "	\r\n"
				    + " return %1$sEntity.builder()\n", feedData.getFileName());
			
			writer.append(str);
			
			Arrays.stream(allFields).forEach(field -> {
				try {
					writer.append(".");
					writer.append(field.getName());
					writer.append("(viewObject.get");
					writer.append(Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1));
					writer.append("())\n");
				} catch (IOException i) {
					i.printStackTrace();
				}
			});
			
			str = String.format(""
				    + ".build();\r\n"
				    + "	}\r\n"
				    + "\r\n"
				    + "}",
				    feedData.getFileName());
			writer.append(str);
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	
}

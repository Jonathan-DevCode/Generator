package com.project.Generator.fireline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

import com.project.Generator.base.FeedData;
import com.project.Generator.interfaces.StartTask;

public class ViewObject implements StartTask {

	@Override
	public void go(FeedData feedData) {
		try {
			File file = new File(String.format(feedData.getDirectory() + "%sVO.java", feedData.getFileName()));

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String str = String.format(""
					+ "@Data @Builder\r\n"
					+ "public class Test1 implements Serializable {\r\n"
					+ "\r\n"
					+ "	private static final long serialVersionUID = 1L;\r\n"
					+ "\r\n", feedData.getFileName());
			
			writer.append(str);
			Field[] allFields = feedData.getRequestModel().getDeclaredFields();
			Arrays.stream(allFields).forEach(field -> {
				try {
					writer.append("\tprivate");
					writer.append(" ");
					writer.append(field.getType().getSimpleName());
					writer.append(" ");
					writer.append(field.getName());
					writer.append(";\n");
				} catch (IOException i) {
					i.printStackTrace();
				}
			});

			writer.append("\n}");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	

}

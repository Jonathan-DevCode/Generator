package com.project.Generator.fireline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.project.Generator.base.FeedData;
import com.project.Generator.interfaces.StartTask;

public class Specification implements StartTask {

	@Override
	public void go(FeedData feedData) {
		File file = new File(String.format(feedData.getDirectory() + "%sSpecification.java", feedData.getFileName()));

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String str = String.format("" +
			"public class Test1Specification implements Specification<Test1Entity> {\r\n"
			+ "\r\n"
			+ "	private static final long serialVersionUID = 1L;\r\n"
			+ "\r\n"
			+ "	private final transient Test1FilterVO filter;\r\n"
			+ "\r\n"
			+ "	public Test1Specification(Test1filterVO filter) {\r\n"
			+ "		this.filter = filter;\r\n"
			+ "	}\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "	@Override\r\n"
			+ "	public Predicate toPredicate(Root<Test1Entity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {\r\n"
			+ "\r\n"
			+ "		List<Predicate> conditions = new ArrayList<>();\r\n"
			+ "\r\n"
			+ "		// Add conditions here\r\n"
			+ "		\r\n"
			+ "		return criteriaBuilder.and(conditions.toArray(new Predicate[0]));\r\n"
			+ "	}\r\n"
			+ "}", feedData.getFileName());
			
			writer.append(str);
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

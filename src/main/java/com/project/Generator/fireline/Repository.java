package com.project.Generator.fireline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.project.Generator.base.FeedData;
import com.project.Generator.interfaces.StartTask;

public class Repository implements StartTask {

	@Override
	public void go(FeedData feedData) {
		try {
			File file = new File(String.format(feedData.getDirectory() + "%sRepository.java", feedData.getFileName()));

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String str = String.format(""
					+ "public interface %1$sRepository extends PagingAndSortingRepository<%1$sEntity, Long> {\r\n"
					+ "\r\n"
					+ "	Page<%1$sEntity> findAll(Specification<%1$sEntity> search, Pageable pageable);\r\n"
					+ "}", feedData.getFileName());
			writer.append(str);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}

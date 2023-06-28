package com.project.Generator.fireline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.project.Generator.base.FeedData;
import com.project.Generator.interfaces.StartTask;

public class Service implements StartTask {

	@Override
	public void go(FeedData feedData) {
		try {
			File file = new File(String.format(feedData.getDirectory() + "%1$sService.java", feedData.getFileName()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			String str = String.format(""
					+ "@Service\r\n"
					+ "public class %1$sService {\r\n"
					+ "	\r\n"
					+ "	public %1$sVO findById(Long id) {\r\n"
					+ "		%1$sEntity result = %1$sRepository.findById(id).orElseThrow(() -> new NotFoundException(\"Data was not found for ID: \" + id));\r\n"
					+ "		return %1$sVOFactory.convertToVO(result);\r\n"
					+ "	}\r\n"
					+ "\r\n"
					+ "	public Page<%1$sVO> findWhitFilters(Pageable page, %1$sVO filters) {\r\n"
					+ "\r\n"
					+ "		if(filters.doNotExist()) {\r\n"
					+ "			throw new InvalidFilterException(\"Filtros inexistentes\");\r\n"
					+ "		}\r\n"
					+ "\r\n"
					+ "		Page<%1$sEntity> result = %1$sRepository.findAll(new %1$sSpecification(filters), page);\r\n"
					+ "		return %1$sVOFactory.toPage(result);\r\n"
					+ "	}\r\n"
					+ "	\r\n"
					+ "	public void saveInfo(%1$sVO %1$sVO) {\r\n"
					+ "		%1$sEntity newData = %1$sEntityFactory.convertToEntity(%1$sVO);\r\n"
					+ "		newData = %1$sRepository.save(newData);\r\n"
					+ "		\r\n"
					+ "		return VOFactory.convertToVO(newData);\r\n"
					+ "	}\r\n"
					+ "	\r\n"
					+ "	public void updateInfo(%1$sVO %1$sVO) {\r\n"
					+ "		\r\n"
					+ "		%1$sEntity updatedData = %1$sRepository.findById(%1$sVO.getId()).orElseThrow(() -> new NotFoundException(\"Data was not found for ID: \" + %1$sVO.getId()));\r\n"
					+ "		\r\n"
					+ "		%1$sEntity newData = %1$sEntityFactory.convertToEntity(%1$sVO);\r\n"
					+ "		newData = %1$sRepository.save(newData);\r\n"
					+ "		\r\n"
					+ "		return VOFactory.convertToVO(newData);\r\n"
					+ "	}\r\n"
					+ "	\r\n"
					+ "	public void deleteInfo(%1$sVO %1$sVO) {\r\n"
					+ "		%1$sEntity result = %1$sRepository.findById(id).orElseThrow(() -> new NotFoundException(\"Data was not found for ID: \" + id));\r\n"
					+ "		%1$sRepository.delete(result);\r\n"
					+ "	}\r\n"
					+ "}", feedData.getFileName());
			writer.append(str);
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}

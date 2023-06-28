package com.project.Generator.fireline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.project.Generator.base.FeedData;
import com.project.Generator.interfaces.StartTask;

public class Controller implements StartTask {

	@Override
	public void go(FeedData feedData) {
		try {
			File file = new File(String.format(feedData.getDirectory() + "%sController.java", feedData.getFileName()));

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String str = String.format("" +
			"@RestController\r\n"
			+ "@RequestMapping\r\n"
			+ "@CrossOrigin(origins = \"*\", allowedHeaders = \"*\")\r\n"
			+ "public class %1$sController {\r\n"
			+ "\r\n"
			+ "	@Autowired\r\n"
			+ "	private %1$sService %2$sService;\r\n"
			+ "\r\n"
			+ "	@GetMapping(\"/{id}\")\r\n"
			+ "	public %1$sVO findById(@PathVariable Long id) {\r\n"
			+ "		 return %2$sService.find%1$sById(id);\r\n"
			+ "	}\r\n"
			+ "\r\n"
			+ "	@GetMapping(\"/filters\")\r\n"
			+ "	public %1$sVO findWhitFilters(@PageableDefault(size = 20) Pageable pageRequest, %1$sFilterVO filterVO) {\r\n"
			+ "		 return %2$sService.find%1$swhitFilters(filterVO);\r\n"
			+ "	}\r\n"
			+ "\r\n"
			+ "	@PostMapping\r\n"
			+ "	@ResponseStatus(HttpStatus.CREATED)\r\n"
			+ "	public %1$sVO registerData(@RequestBody %1$sVO requestVO) {\r\n"
			+ "		 return %2$sService.registerOperation(requestVO);\r\n"
			+ "	}\r\n"
			+ "\r\n"
			+ "	@PutMapping\r\n"
			+ "	public %1$sVO updateData(@RequestBody %1$sVO requestVO) {\r\n"
			+ "		 return %2$sService.updateOperation(requestVO);\r\n"
			+ "	}\r\n"
			+ "\r\n"
			+ "	@DeleteMapping\r\n"
			+ "	public %1$sVO deleteData(@RequestBody %1$sVO requestVO) {\r\n"
			+ "		 return %2$sService.deleteOperation(requestVO);\r\n"
			+ "	}\r\n"
			+ "\r\n"
			+ "}", feedData.getFileName(), feedData.getFileName().toLowerCase());
			writer.append(str);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

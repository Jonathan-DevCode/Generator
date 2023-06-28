package com.project.Generator.base;

public class FeedData {

	Class<?> requestModel; 
	String fileName; 
	String packageName; 
	String directory;
	
	public Class<?> getRequestModel() {
		return requestModel;
	}
	public void setRequestModel(Class<?> requestModel) {
		this.requestModel = requestModel;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	
}

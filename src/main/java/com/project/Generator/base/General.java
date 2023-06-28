package com.project.Generator.base;

import com.project.Generator.fireline.Controller;
import com.project.Generator.fireline.Entity;
import com.project.Generator.fireline.Factory;
import com.project.Generator.fireline.Repository;
import com.project.Generator.fireline.Service;
import com.project.Generator.fireline.ViewObject;
import com.project.Generator.objective.Test1;

public class General {
	
	public void go() {
		
		Test1 classArch = new Test1();

		FeedData feedData = new FeedData();
		feedData.setDirectory("C:\\Users\\jonat\\Desktop\\Projetos\\Generated\\");
		feedData.setFileName(classArch.getClass().getSimpleName());
		feedData.setPackageName("br.com.generator");
		feedData.setRequestModel(classArch.getClass());
		
		new Controller().go(feedData);
		new Entity().go(feedData);
		new Factory().go(feedData);
		new Repository().go(feedData);
		new Service().go(feedData);
		new ViewObject().go(feedData);

	}

	
}

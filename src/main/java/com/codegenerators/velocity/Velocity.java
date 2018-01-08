package com.codegenerators.velocity;

import java.io.StringWriter;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import com.codegenerators.dtos.ClassStructure;
import com.codegenerators.utils.ExcelUtil;
import com.codegenerators.utils.FileUtil;

public class Velocity {
	
	private final String TEMPLATES = "com/codegenerators/velocity/templates/";
	private final String DTO_TEMPLATE = "DTOTemplate.vm";
	VelocityEngine ve = null;
	
	public Velocity() {
		init();
	}
	
	private void init() {
		ve = new VelocityEngine();
		//设置velocity资源加载方式为classpath  
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		
		//设置velocity资源加载方式为file
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
//		ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "com/codegenerators/velocity/templates");
//		ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");  
		
		//设置velocity资源加载方式为class, 类路径加载方式
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");  
        ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); 
        
		ve.setProperty("input.encoding", "UTF-8");
		ve.setProperty("output.encoding", "UTF-8");
		ve.init();
	}
	
	public void run() {
		VelocityContext context = new VelocityContext();
		List<ClassStructure> list = ExcelUtil.getMorckUpData();
		String outDir = FileUtil.getProjectDir() + "\\OutDTO\\";
		
		String tempPath = TEMPLATES + DTO_TEMPLATE;
		if (!ve.resourceExists(tempPath)) {
			System.out.println("Can not find template of '" + DTO_TEMPLATE + "'!");
			return;
		}
		Template t = ve.getTemplate(tempPath);
		StringWriter sw = null;
		String outPath = null;
		
		for(int i = 0; i < list.size(); i++) {
			sw = new StringWriter();
			ClassStructure classDto = list.get(i);
			classDto.setClassName(classDto.getClassName() + "_VM");// need remove
			outPath = outDir + classDto.getClassName() + ".gs";
			context.put("data", classDto);
			t.merge(context, sw);
			FileUtil.writeFile(outPath, sw.toString());
			System.out.println("Generator successfully : " + outPath);
		}
	}

}

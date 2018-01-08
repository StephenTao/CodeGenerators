package com.codegenerators.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import com.codegenerators.utils.ExcelUtil;
import com.codegenerators.utils.FileUtil;
import com.codegenerators.dtos.ClassStructure;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class Freemarker {
	
	private final String TEMPLATES = "templates";
	private final String DTO_TEMPLATE = "DTOTemplate.ftl";
	private final String EMPTY= "";
	private Configuration cfg = null;
	
	public Freemarker() {
		init();
	}
	
	private void init() {
		if (cfg == null) {
			cfg = new Configuration(Configuration.VERSION_2_3_23);
		}
		String templatesDir = Freemarker.class.getResource(EMPTY).getPath() + TEMPLATES;
		File dir = new File(templatesDir);
		if (dir.isDirectory()) {
			try {
				cfg.setDirectoryForTemplateLoading(dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		List<ClassStructure> list = ExcelUtil.getMorckUpData();
		String outDir = FileUtil.getProjectDir() + "\\OutDTO\\";
		FileUtil.createDir(outDir);
		String outPath = outDir;
		StringWriter sw = null;
		Template template = null;
		try {
			template = cfg.getTemplate(DTO_TEMPLATE);
		} catch (TemplateNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < list.size(); i++) {
			sw = new StringWriter();
			ClassStructure classDto = list.get(i);
			classDto.setClassName(classDto.getClassName() + "_FM");// need remove
			outPath = outDir + classDto.getClassName() + ".gs";
			try {
				template.process(classDto, sw);
				FileUtil.writeFile(outPath, sw.toString());
				System.out.println("Generator successfully : " + outPath);
			} catch (TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

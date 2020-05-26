package com.ead.ims.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.multipart.MultipartFile;

import com.ead.ims.controller.IMSController;
import com.ead.ims.model.Product;

public class FileUpload {
	private final static Logger logger = Logger.getLogger(FileUpload.class.getName());
	private static String TEMP_FOLDER = "C://temp//";

	public static List<Product> upload(MultipartFile file){
	List<Product> content = null;

	if (file.isEmpty())
	{
		return null;
	}
	try 
	{
		byte[] bytes = file.getBytes();
		Path path = Paths.get(TEMP_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);
		content = ReadCSV.readfile(path.toString());
	}
	catch (IOException e)
	{
		logger.info("There was an error reading the file");
		logger.info("The exception is : "+e);
	}
	catch(Exception e)
	{
		logger.info("The exception is : "+e);
	}
	return content;
}
}

/**
 * 
 */
package com.wasadc.upload;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Juliano Cassoli
 *
 */
@Controller
public class UpLoadController {

	private static final Logger logger = LogManager.getLogger(UpLoadController.class);
	
	@RequestMapping(value="/upload")
	public String enterUpload() {
		
		return "upload/chooseToUp";
	}
	
	@RequestMapping(value="/save")
	public String handleFileUpload(@RequestParam(value="comment") String comment, 
            @RequestParam("file") MultipartFile file, HttpServletRequest request, 
			HttpServletResponse response){
		
		if (!file.isEmpty()) {
			
			String fileName = file.getOriginalFilename();
			logger.info("file name: " + fileName);
			logger.info("Comment: " + comment);
			
			try {
				InputStream is = file.getInputStream();
				byte[] buffer = new byte[100_000];
				int len;
				while ((len = is.read(buffer)) != -1) {
					logger.info("reading " + len + " bytes");
				}
				is.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
            return "upload/upFailed";
        }
		
		return "upload/upSucceeded";
	}
	
}

package com.mongo.mobile.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mongo.mobile.exception.ServiceMessage;
import com.mongo.mobile.util.FileUtil;

@Controller
@RequestMapping("/uploadify")
public class FileUploadController extends BaseController {
	
	private static Logger logger = Logger.getLogger(FileUploadController.class);

	@RequestMapping("/upload")
	@ResponseBody
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) {
		boolean flag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		if (!file.isEmpty()) { //判断文件是否为空
			String path = request.getSession().getServletContext().getRealPath("uploads");  
	        String fileName = file.getOriginalFilename();
	        String fileSuffix = FileUtil.getFileSuffix(fileName);
	        fileName = FileUtil.getFileName() + fileSuffix;
 
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        try {  
	            file.transferTo(targetFile);
	            map.put("fileName", fileName);
	        } catch (Exception e) { 
	        	flag = false; 
	        }
		}
		map.put("flag", flag);
        return map;  
    }
	
	@RequestMapping("/uploads")
    public String uploads(@RequestParam("files") MultipartFile[] files, Model model) {  
        return "result";  
    }
	
	@RequestMapping("/uploadJson")
	@ResponseBody
    public Object uploadJson(@RequestParam("imgFile") MultipartFile file, Model model, HttpServletRequest request) {
		ServiceMessage message = null;
		if (!file.isEmpty()) { //判断文件是否为空
			String dir = request.getParameter("dir");
			if (StringUtils.isEmpty(dir)) {
				dir = "image";
			}
			String path = request.getSession().getServletContext().getRealPath("uploads/kindes/" + dir);
			String url = request.getContextPath() + "/uploads/kindes/" + dir + "/";
			
	        String fileName = file.getOriginalFilename();
	        String fileSuffix = FileUtil.getFileSuffix(fileName);
	        fileName = FileUtil.getFileName() + fileSuffix;

	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        try {  
	            file.transferTo(targetFile);
	            message = new ServiceMessage(ServiceMessage.SUCCESS, url + fileName);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	logger.error("上传失败");
	        	message = new ServiceMessage(ServiceMessage.ERROR, "上传失败");
	        }
		}
        return message;  
    }
}
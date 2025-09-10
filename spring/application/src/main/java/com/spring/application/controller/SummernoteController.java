package com.spring.application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/summernote")
public record SummernoteController(@Value("${summernote.img}") String imgPath) {

    @PostMapping(value="/uploadImg")
	public ResponseEntity<String> uploadImg(MultipartFile file,
			                                HttpServletRequest request)	
															throws IOException {
		ResponseEntity<String> result = null;
		
		String savePath = imgPath.replace("/", File.separator);
		String fileName = UUID.randomUUID().toString()+".jpg"; 
		File saveFile = new File(savePath, fileName);

		saveFile.mkdirs();
		
		file.transferTo(saveFile);
		
		result = new ResponseEntity<String>(request.getContextPath() 
				+ "/summernote/getImg?fileName=" + fileName,HttpStatus.OK);
		return result;
	}

    @GetMapping("/getImg")
    public ResponseEntity<byte[]> getImg(String fileName) throws Exception{
        
        ResponseEntity<byte[]> entity = null;

        String savePath = imgPath.replace("/",File.separator);
        File sendFile = new File(savePath, fileName);

        InputStream in = null;
        try{
            in = new FileInputStream(sendFile);
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),HttpStatus.OK);
        } finally{
            if (in != null)
            in.close();
        }
        return entity;
    }

    @GetMapping("/deleteImg")
    public ResponseEntity<String> deleteImg(String fileName){
        ResponseEntity<String> result = null;

        String savePath= imgPath.replace("/",File.separator);
        File target = new File(savePath, fileName);

        if (!target.exists()){
            result = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }else{
            target.delete();
            result = new ResponseEntity<String>(fileName, HttpStatus.OK);
        }
        return result;
    }


}
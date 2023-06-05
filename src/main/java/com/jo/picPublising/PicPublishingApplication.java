package com.jo.picPublising;

import com.jo.picPublising.business.service.UploadFilesService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PicPublishingApplication {

	@Resource
	UploadFilesService uploadFilesService;
	public static void main(String[] args) {
		SpringApplication.run(PicPublishingApplication.class, args);
	}

}

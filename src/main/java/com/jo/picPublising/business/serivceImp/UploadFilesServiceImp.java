package com.jo.picPublising.business.serivceImp;

import com.jo.picPublising.business.service.UploadFilesService;
import com.jo.picPublising.security.jwt.JwtAuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class UploadFilesServiceImp implements UploadFilesService {
    private static final Logger logger = LoggerFactory.getLogger(UploadFilesServiceImp.class);

    //Path is work with files and direction
    Path root = Paths.get("media");
    @Override
    public void init() {
        if(!Files.exists(root)){ ///Files to read and write files and direction and
            try{
                Files.createDirectories(root);
                logger.info("root of Direction is " + root.getFileName());
            }catch (IOException e) {
                logger.error("IOException when createing root" );
                throw new RuntimeException("Error when Create Direction");

            }
        }

    }

    @Override
    public void saveFile() {

    }
}

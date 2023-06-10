package com.jo.picPublising.business.serivceImp;

import com.jo.picPublising.business.dto.response.ResponseDto;
import com.jo.picPublising.business.service.UploadFilesService;
import com.jo.picPublising.security.jwt.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class UploadFilesServiceImp implements UploadFilesService {
    private static final Logger logger = LoggerFactory.getLogger(UploadFilesServiceImp.class);

    //Path is work with files and direction
    Path root = Paths.get("test111111");

    {
        logger.info("first loggggger");
         ///Files to read and write files and direction and
            try{
                Files.createDirectories(root);
                logger.info("root of Direction is " + root.getFileName());
            }catch (IOException e) {
                logger.error("IOException when createing root" );
                throw new RuntimeException("Error when Create Direction");

            }

    }

    @Override
    public String saveFile(MultipartFile file) {

        try{
            logger.info("inside try of save File");
            createtypePath(file.getContentType());
            Path concatPath = this.root.resolve(createTypeDict(file));
            logger.info("inside try of save File and path is:  " + concatPath);
            Files.copy(file.getInputStream(), concatPath);

        }catch (Exception e){
            if(e instanceof FileAlreadyExistsException){
                logger.error("inside catch(fileAlreadyExist) of save File");
                throw new RuntimeException("File is Already exist");
            }
            logger.info("inside catch(exception) of save File , Error: " + e.getMessage());
            e.printStackTrace();
        }
        return "File saved Successfully";

    }

    @Override
    public ResponseDto loadFile(Long id) {
        return null;
    }

    @Override
    public ResponseDto loadAll() {
        return null;
    }

    private void createtypePath(String typeFile){

        Path newPath = this.root.resolve(typeFile);
        try{
            logger.info("inside create type path  try() for create path: " + newPath);
            Path typePath = Files.createDirectories(newPath);
            logger.info("After creating path");
        } catch (IOException e) {
            logger.error("cant create type path");
            throw new RuntimeException(e.getMessage());
        }
    }

    private String createTypeDict(MultipartFile file){
        String path = file.getContentType() + file.getOriginalFilename();
        logger.info("Type of file path is :" + path);
        return path;
    }
}

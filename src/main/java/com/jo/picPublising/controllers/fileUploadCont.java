package com.jo.picPublising.controllers;


import com.jo.picPublising.business.service.UploadFilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class fileUploadCont {
    private final UploadFilesService uploadFilesService;


    @PostMapping("/uploadfile")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String UploadFile( @RequestParam("file") MultipartFile file) {

        try{
            return uploadFilesService.saveFile(file);
        }catch(Exception e){
//            return "cant upload file:" + file.getOriginalFilename() + " Error: " + e.getMessage();
            e.printStackTrace();
        }
        return "test";


    }

}

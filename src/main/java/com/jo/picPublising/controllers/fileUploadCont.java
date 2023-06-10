package com.jo.picPublising.controllers;


import com.jo.picPublising.business.dto.response.ResponseDto;
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
    public ResponseDto UploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        try{
            return uploadFilesService.saveFile(file);
        }catch(Exception e){
//            return "cant upload file:" + file.getOriginalFilename() + " Error: " + e.getMessage();
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

}

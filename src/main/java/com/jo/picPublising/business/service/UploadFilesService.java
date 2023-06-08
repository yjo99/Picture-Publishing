package com.jo.picPublising.business.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFilesService {

     String saveFile(MultipartFile file);

     ResponseDto loadFile(Long id);
     ResponseDto loadAll();


}

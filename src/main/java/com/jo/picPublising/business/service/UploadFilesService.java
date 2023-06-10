package com.jo.picPublising.business.service;

import com.jo.picPublising.business.dto.response.ResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFilesService {

     ResponseDto saveFile(MultipartFile file);

     ResponseDto loadFile(Long id);
     ResponseDto loadAll();


}

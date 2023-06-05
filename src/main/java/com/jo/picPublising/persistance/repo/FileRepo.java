package com.jo.picPublising.persistance.repo;

import com.jo.picPublising.persistance.models.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<FileData, Long> {
}

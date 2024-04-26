package com.example.spring_11200.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileStorageService {

    String saveFile(MultipartFile file, String description, int likes);

    void writeFileToResponse(String fileName, HttpServletResponse response);

}

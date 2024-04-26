package com.example.spring_11200.controllers;

import com.example.spring_11200.models.FileInfo;
import com.example.spring_11200.repositories.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FilesUploadedController {
    @Autowired
    private FilesRepository filesRepository;

    @GetMapping("/files/uploaded")
    public String getUploadedFiles(Model model) {
        List <FileInfo> files = filesRepository.findAll();
        model.addAttribute("files", files);
        return "file_uploaded";
    }
}

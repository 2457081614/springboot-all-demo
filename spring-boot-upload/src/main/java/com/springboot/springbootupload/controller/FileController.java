package com.springboot.springbootupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;

/**
 * @author
 * @Description 文件操作类
 */
@Controller
public class FileController {


    /**
     * 上传单个文件
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path("aaa.txt")
                .toUriString();
        file.transferTo(new File("D:\\a.dll"));
        return "上传成功";
    }


}

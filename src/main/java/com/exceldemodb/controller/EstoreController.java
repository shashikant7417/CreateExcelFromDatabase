package com.exceldemodb.controller;

import com.exceldemodb.service.EstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/estore")
public class EstoreController {

    @Autowired
    private EstoreService estoreService;

    @GetMapping("/excel")
    public ResponseEntity<Resource> downloadExcel() throws IOException {

        String fileName = "estore.xlsx";
         ByteArrayInputStream actualData = estoreService.getActualData();
        InputStreamResource file = new InputStreamResource(actualData);

         ResponseEntity<Resource> response = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment ; fileName= " + fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);

         return response;

    }
}

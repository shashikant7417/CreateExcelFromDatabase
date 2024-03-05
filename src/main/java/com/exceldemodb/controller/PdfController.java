package com.exceldemodb.controller;

import com.exceldemodb.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/createPdf")
    public ResponseEntity<InputStreamResource> createPdf(){

         ByteArrayInputStream inputStream = pdfService.createPdf();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline;file = Shashi.pdf");

        return ResponseEntity
                .ok()
                .header("httpHeaders")
                .contentType(MediaType.APPLICATION_PDF).
                body(new InputStreamResource(inputStream));

    }
}

package com.portfolio.personalPortfolio.controller;


import com.portfolio.personalPortfolio.business.abstracts.PdfFileService;
import com.portfolio.personalPortfolio.business.concretes.PdfFileManager;
import com.portfolio.personalPortfolio.entities.PdfFile;
import com.portfolio.personalPortfolio.repository.PdfFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class PdfController {


    private PdfFileService pdfFileService;
    private PdfFileRepository pdfFileRepository;
    private PdfFileManager pdfFileManager;

    @Autowired
    public PdfController(PdfFileManager pdfFileManager) {
        this.pdfFileManager = pdfFileManager;
    }

    @PostMapping("/upload-pdf")
    public ResponseEntity<PdfFile> uploadPdf(@RequestParam("pdf") MultipartFile pdfFile) throws IOException {
        PdfFile uploadedPdf = pdfFileService.uploadPdf(pdfFile);
        return ResponseEntity.ok(uploadedPdf);
    }

    @GetMapping("/download-pdf")
    public ResponseEntity<byte[]> downloadPdf() throws IOException {
        byte[] pdfContent = pdfFileManager.getPdfContent();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "src/main/resources/pdf/ozgucResumeUpdated.pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }


}

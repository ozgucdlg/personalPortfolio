package com.portfolio.personalPortfolio.controller;


import com.portfolio.personalPortfolio.business.abstracts.PdfFileService;
import com.portfolio.personalPortfolio.entities.PdfFile;
import com.portfolio.personalPortfolio.repository.PdfFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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

    @PostMapping("/upload")
    public ResponseEntity<PdfFile> uploadPdf(@RequestParam("pdf") MultipartFile pdfFile) throws IOException {
        PdfFile uploadedPdf = pdfFileService.uploadPdf(pdfFile);
        return ResponseEntity.ok(uploadedPdf);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadPdf(@PathVariable int id) {


        Optional<PdfFile> pdfFileOptional = pdfFileRepository.findById(id);

        if (pdfFileOptional.isPresent()) {
            PdfFile pdfFile = pdfFileOptional.get();

            ByteArrayResource resource = new ByteArrayResource(pdfFile.getContent());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdfFile.getFileName() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

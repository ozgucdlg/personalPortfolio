package com.portfolio.personalPortfolio.business.concretes;


import com.portfolio.personalPortfolio.entities.PdfFile;
import com.portfolio.personalPortfolio.repository.PdfFileRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PdfFileManager  {

    private PdfFileRepository pdfFileRepository;
    private PdfFileManager pdfFileManager;



    public PdfFile uploadPdf(MultipartFile pdfFile) {
        try {
            PdfFile newPdfFile = new PdfFile();
            newPdfFile.setFileName(pdfFile.getOriginalFilename());
            newPdfFile.setContent(pdfFile.getBytes());

            return pdfFileRepository.save(newPdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public byte[] getPdfContent() throws IOException {
        Resource resource = new ClassPathResource("pdf/ozgucResumeUpdated.pdf");
        try (InputStream inputStream = resource.getInputStream()) {
            return inputStream.readAllBytes();
        }
    }




}

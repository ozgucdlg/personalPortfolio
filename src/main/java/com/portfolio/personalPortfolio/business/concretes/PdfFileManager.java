package com.portfolio.personalPortfolio.business.concretes;


import com.portfolio.personalPortfolio.entities.PdfFile;
import com.portfolio.personalPortfolio.repository.PdfFileRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PdfFileManager  {

    private PdfFileRepository pdfFileRepository;

    private PdfFileManager pdfFileManager;


    public PdfFile uploadPdf(MultipartFile pdfFile) throws IOException {
        PdfFile newPdfFile = new PdfFile();
        newPdfFile.setFileName(pdfFile.getOriginalFilename());

        // Diğer alanları ayarlayabilirsiniz

        PdfFile savedPdfFile = pdfFileRepository.save(newPdfFile);
        // Dosyayı saklamak ve yönetmek için gerekli işlemleri yapabilirsiniz

        return savedPdfFile;
    }




}

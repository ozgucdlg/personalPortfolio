package com.portfolio.personalPortfolio.business.abstracts;

import com.portfolio.personalPortfolio.entities.PdfFile;
import org.springframework.web.multipart.MultipartFile;

public interface PdfFileService {

     PdfFile uploadPdf(MultipartFile pdfFile);
     PdfFile savedFile(PdfFile pdfFile );
     byte[] getPdfContent();

}

package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.codec.Base64;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
@Service
public interface PdfService {

void generatePdf(Employee employee, OutputStream outputStream ) throws DocumentException;
}


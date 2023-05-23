package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.model.Salary;
import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
@Service
public interface PdfService {

void generatePersonalDataPdf(Employee employee, OutputStream outputStream ) throws DocumentException;
void generateSalaryPdf(Salary salary, OutputStream outputStream)throws DocumentException;
}


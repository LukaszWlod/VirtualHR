package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.OutputStream;

@Service
public class PdfServiceImp  implements PdfService{
    @Override
    public void generatePdf(Employee employee, OutputStream outputStream) throws DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        addContent(document, employee);
        document.close();
    }

    private void addContent(Document document, Employee employee) throws DocumentException {
        Paragraph heading = new Paragraph("Twoje Dane osobowe");
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);
        document.add(Chunk.NEWLINE);



        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{2, 5});

        addCell(table, "Imię:", employee.getName());
        addCell(table, "Nazwisko:", employee.getLastName());
        addCell(table, "PESEL:", employee.getPesel());
        addCell(table, "Email:", employee.getEmail());
        addCell(table, "Ulica:", employee.getStreet());
        addCell(table, "Numer domu:", String.valueOf(employee.getHouseNumber()));
        addCell(table, "Kod poczotowy:", employee.getZipCode());
        addCell(table, "Data urodzenia:", employee.getDateOfBirth().toString());
        addCell(table, "Numer telefonu:", String.valueOf(employee.getPhoneNumber()));
        addCell(table, "Miasto:", employee.getCity());

        document.add(table);
    }

    private void addCell(PdfPTable table, String label, String value) {

        Font cellFont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 12);

        PdfPCell labelCell = new PdfPCell(new Phrase(label,cellFont));
        labelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        labelCell.setBorder(Rectangle.NO_BORDER);
        table.addCell(labelCell);

        PdfPCell valueCell = new PdfPCell(new Phrase(value,cellFont));
        valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        valueCell.setBorder(Rectangle.NO_BORDER);
        table.addCell(valueCell);
    }

}


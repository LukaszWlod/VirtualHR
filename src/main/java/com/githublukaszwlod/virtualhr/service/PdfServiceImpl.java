package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.model.Salary;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;


import java.io.OutputStream;

@Service
public class PdfServiceImpl implements PdfService{
    @Override
    public void generatePersonalDataPdf(Employee employee, OutputStream outputStream) throws DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        addPersonalDataContent(document, employee);
        document.close();
    }

    @Override
    public void generateSalaryPdf(Salary salary, OutputStream outputStream) throws DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        addSalaryContent(document, salary);
        document.close();
    }

    private void addSalaryContent(Document document, Salary salary) throws DocumentException {
        Font headingFont = FontFactory.getFont(BaseFont.HELVETICA_BOLD,BaseFont.CP1250,BaseFont.EMBEDDED, 16, Font.BOLD, BaseColor.BLACK);

        String title = salary.getEmployee().getName() +" "+ salary.getEmployee().getLastName()
                +"\n"+ "Odcinek płacowy"+"\n"+salary.getPayrollPeriod();

        Paragraph heading = new Paragraph(title , headingFont);
        heading.setAlignment(Element.ALIGN_CENTER);
        heading.setSpacingAfter(20);
        document.add(heading);


        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{2,1,2,1});
        table.setSpacingAfter(30);

        addCell(table, "Okres rozliczeniowy:", salary.getPayrollPeriod());
        addCell(table, "Data płatności:", salary.getPaymentDate().toString());
        addCell(table, "Godziny przepracowane:", String.valueOf(salary.getWorkedHours()));
        addCell(table, "Ilość nadgodzin:", String.valueOf(salary.getOvertimeHours()));
        addCell(table, "Dni urlopu:", String.valueOf(salary.getVacationDays()));
        addCell(table, "Płatność za urolop:", String.valueOf(salary.getVacationPayment()));
        addCell(table, "Dni zwolnienia lekarskiego:", String.valueOf(salary.getSickLeaveDays()));
        addCell(table, "Zasiłek chorobowy:", String.valueOf(salary.getSickLeavePay()));
        addCell(table, "Składka emerytalna:", String.valueOf(salary.getPensionablePay()));
        addCell(table, "Ubezpieczenie rentowe:", String.valueOf(salary.getDisabilityInsurance()));
        addCell(table, "Zaliczka na podatek dochodowy:", String.valueOf(salary.getTax()));
        addCell(table, "Ubezpieczenie chorobowe:", String.valueOf(salary.getSicknessInsurance()));
        addCell(table, "Wynagrodzenie brutto:", String.valueOf(salary.getGrossSalary()));
        addCell(table, "Wynagrodzenie netto:", String.valueOf(salary.getNetSalary()));

        document.add(table);
    }



    private void addPersonalDataContent(Document document, Employee employee) throws DocumentException {
        Paragraph heading = new Paragraph("Twoje Dane osobowe");
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);
        document.add(Chunk.NEWLINE);



        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{2,1,2,1});

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


        Font labelFont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED ,12, Font.BOLD, BaseColor.DARK_GRAY);
        Font valueFont = FontFactory.getFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED, 12, Font.NORMAL, BaseColor.BLACK);

        PdfPCell labelCell = new PdfPCell(new Phrase(label, labelFont));
        labelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        labelCell.setBorder(Rectangle.NO_BORDER);
        labelCell.setPaddingLeft(60);
        labelCell.setPaddingTop(25);
        table.addCell(labelCell);

        PdfPCell valueCell = new PdfPCell(new Phrase(value, valueFont));
        valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        valueCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        valueCell.setBorder(Rectangle.NO_BORDER);
        valueCell.setPaddingRight(1);
        valueCell.setPaddingTop(25);
        table.addCell(valueCell);
    }






}


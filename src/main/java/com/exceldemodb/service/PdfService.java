package com.exceldemodb.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

   private Logger logger = LoggerFactory.getLogger(PdfService.class);

    public ByteArrayInputStream createPdf(){

        logger.info("Pdf Started");

        String title = "Demo Pdf creation";
        String content = "Working hard to learn the concepts of spring boot Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum ";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document,out);

        HeaderFooter footer = new HeaderFooter(true, new Phrase(" I am a Footer"));
        footer.setAlignment(Element.ALIGN_CENTER);
        footer.setBorderWidthBottom(0);
        document.setFooter(footer);
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
        Paragraph titlePara = new Paragraph(title,titleFont);
        titlePara.setAlignment(Element.ALIGN_CENTER);
        document.add(titlePara);

        Font contentFont = FontFactory.getFont(FontFactory.TIMES_ROMAN,15);
        Paragraph contentPara = new Paragraph(content);
        contentPara.add(new Chunk("Chunk is added to this para"));
        document.add(contentPara);
        document.newPage();
        document.add(new Paragraph("  Para 1 added "));
        document.newPage();
        document.add(new Paragraph(" Para 2 added "));
        document.newPage();
        document.add(new Paragraph(" Para 3 added "));

        document.close();

        return new ByteArrayInputStream(out.toByteArray());

    }
}

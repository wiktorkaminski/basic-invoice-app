package wiktorkaminski.basicinvoiceapp.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.springframework.stereotype.Component;
import wiktorkaminski.basicinvoiceapp.entity.Invoice;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceRepository;

import java.io.IOException;
import java.util.Optional;

public class PdfCreator {

//    private final InvoiceRepository invoiceRepository;
//
//    public PdfCreator(InvoiceRepository invoiceRepository) {
//        this.invoiceRepository = invoiceRepository;
//    }
//
//    public void print() throws IOException {
//        Invoice invoice = invoiceRepository.findById(23L).get();
//
//        PDDocument document = new PDDocument();
//        PDPage pdPage = new PDPage();
//        PDPageContentStream contentStream = new PDPageContentStream(document, pdPage);
//        document.addPage(pdPage);
//
//
//        contentStream.beginText();
//        contentStream.setFont(PDType1Font.COURIER, 9);
//        contentStream.newLineAtOffset(25, 700);
//        contentStream.
//
//        contentStream.endText();
//
//
//        document.save("/newPDFfile.pdf");
//        document.close();
//
//    }


}

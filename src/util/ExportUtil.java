/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.io.BufferedWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
import javax.swing.JTable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nazlya
 */
public class ExportUtil {
    public static void exportToPDF(JTable table, File file) throws IOException {
        // Implementasi ekspor ke PDF
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                //contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 700);
                for (int row = 0; row < table.getRowCount(); row++) {
                    for (int column = 0; column < table.getColumnCount(); column++) {
                        contentStream.showText(table.getValueAt(row, column).toString());
                        contentStream.newLineAtOffset(100, -20); // Space between rows
                    }
                }
                contentStream.endText();
            }
            document.save(file);
        }
    }

    public static void exportToCSV(JTable table, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int column = 0; column < table.getColumnCount(); column++) {
                    writer.write(table.getValueAt(row, column).toString());
                    if (column < table.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        }
    }
}

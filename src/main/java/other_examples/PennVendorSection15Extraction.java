package other_examples;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import java.io.FileWriter;
import java.io.IOException;

public class PennVendorSection15Extraction {
    public void extraction2(String pdf1) throws IOException {
        PdfDocument pdf = new PdfDocument(pdf1);
        PdfTableExtractor extractor = new PdfTableExtractor(pdf);
        PdfTable[] pdfTables = null;
        StringBuilder builder = new StringBuilder();

        for (int pageIndex = 0; pageIndex < pdf.getPages().getCount(); pageIndex++) {
            pdfTables = extractor.extractTable(pageIndex);
            if (pdfTables != null && pdfTables.length > 0) {
                for (PdfTable table : pdfTables) {
                    for (int i = 0; i < table.getRowCount(); i++) {
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            String text = table.getText(i, j);

                            builder.append(text + "  " + table.getText(i, j + 1) + " " + table.getText(i, j + 2));
                        }
                    }
                    builder.append("\r\n");
                }
                builder.append("\r\n");
            }
        }
        FileWriter fw = new FileWriter("/home/lara/PdfParserExample/extract.txt");
        fw.write(builder.toString());
        fw.flush();
        fw.close();

    }
}

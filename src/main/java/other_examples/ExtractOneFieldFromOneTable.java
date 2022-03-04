package other_examples;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractOneFieldFromOneTable {
    public void extraction2(String pdf1, String word) throws IOException {
        PdfDocument pdf = new PdfDocument(pdf1);

        //COLONIAL  /home/lara/Documents/other_vendors/colonial/SDS/327225-01.pdf
        //  /home/lara/Documents/other_vendors/solvay/SDS/OR0476_OR0476_USENG.pdf
        //    NOT WORKING      /home/lara/Documents/other_vendors/dubois/SDS/MPG-0.pdf

        //Create a PdfTableExtractor instance
        PdfTableExtractor extractor = new PdfTableExtractor(pdf);

        //Declare a PdfTable array variable
        PdfTable[] pdfTables = null;

        //Create a StringBuilder instance
        StringBuilder builder = new StringBuilder();

        //Loop through the pages
        for (int pageIndex = 0; pageIndex < pdf.getPages().getCount(); pageIndex++) {

            //Extract tables from the current page
            pdfTables = extractor.extractTable(pageIndex);

            //If any tables are found
            if (pdfTables != null && pdfTables.length > 0) {

                //Loop through the tables
                for (PdfTable table : pdfTables) {

                    //Loop through the rows in the current table
                    for (int i = 0; i < table.getRowCount(); i++) {

                        //Loop through the columns in the current table
                        for (int j = 0; j < table.getColumnCount(); j++) {

                                if (table.getText(i, j).equals(word)) {
                                    //Extract data from the current table cell
                                    String text = table.getText(i, j);

                                    //Append the text to the string builder
                                    builder.append(text + "  " + table.getText(i, j + 1) + " " + table.getText(i, j + 2));

                                }

                        }
                        builder.append("\r\n");
                    }
                    builder.append("\r\n");
                }

            }
        }

        //Write data into a .txt document
        FileWriter fw = new FileWriter("/home/lara/PdfParserExample/extract.txt");
        fw.write(builder.toString());
        fw.flush();
        fw.close();

    }
}

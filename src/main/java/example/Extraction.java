package example;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import java.io.IOException;
import java.util.List;

public class Extraction {
    public List<Value> extraction(String pdf1, List<Value> fields) throws IOException {
        PdfDocument pdf = new PdfDocument(pdf1);

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
                                for(Value value: fields) {
                                    String text = table.getText(i, j);
                                      if(text.equals(value.getKey())){
                                          if(value.getPosition().equals(Enum.RIGHT)){
                                              value.setValue(table.getText(i,j+1));
                                          }
                                           if(value.getPosition().equals(Enum.DOWN)){
                                              value.setValue(table.getText(i+1,j));
                                          }if(value.getPosition().equals(Enum.UP)){
                                              value.setValue(table.getText(i-1,j));
                                          }
                                          if(value.getPosition().equals(Enum.LEFT)){
                                              value.setValue(table.getText(i,j-1));
                                          }
                                      }
                                }
                            }
                        }
                }
            }
        }
        return fields;
    }

}

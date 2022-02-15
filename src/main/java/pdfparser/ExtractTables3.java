//package pdfparser;
//
//import com.spire.pdf.PdfDocument;
//import com.spire.pdf.utilities.PdfTable;
//import com.spire.pdf.utilities.PdfTableExtractor;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import technology.tabula.ObjectExtractor;
//import technology.tabula.Page;
//import technology.tabula.RectangularTextContainer;
//import technology.tabula.Table;
//import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
//
//public class ExtractTables3 {
//    public static void main(String[] args) throws IOException {
//
//        //Load a sample PDF document
//        PdfDocument pdf = new PdfDocument("/home/lara/Documents/other_vendors/eastman/SDS/31354 - SDS.pdf");
//
//        //COLONIAL  /home/lara/Documents/other_vendors/colonial/SDS/327225-01.pdf
//        //  /home/lara/Documents/other_vendors/solvay/SDS/OR0476_OR0476_USENG.pdf
//        //    NOT WORKING      /home/lara/Documents/other_vendors/dubois/SDS/MPG-0.pdf
//
//
//        //Create a PdfTableExtractor instance
//        PdfTableExtractor extractor = new PdfTableExtractor(pdf);
//
//        //Declare a PdfTable array variable
//        PdfTable[] pdfTables = null;
//
//        //Create a StringBuilder instance
//        StringBuilder builder = new StringBuilder();
//
//        //Loop through the pages
//        for (int pageIndex = 0; pageIndex < pdf.getPages().getCount(); pageIndex++) {
//
//            //Extract tables from the current page
//            pdfTables = extractor.extractTable(pageIndex);
//
//            //If any tables are found
//            if (pdfTables != null && pdfTables.length > 0) {
//
//                //Loop through the tables
//                for (PdfTable table : pdfTables) {
//
//                    List<List<RectangularTextContainer>> rows = tables.getRows();
//
//                    for(int i=0; i<rows.size(); i++) {
//
//                        List<RectangularTextContainer> cells = rows.get(i);
//
//                        for(int j=0; j<cells.size(); j++) {
//                            System.out.print(cells.get(j).getText()+" ");
//                        }
//
//                        System.out.println();
//                    }
//                }
//
//            }
//        }
//
//
//        //Write data into a .txt document
//        FileWriter fw = new FileWriter("/home/lara/PdfParserExample/extract.txt");
//        fw.write(builder.toString());
//        fw.flush();
//        fw.close();
//    }
//}
//

package other_examples;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PdfReadFromFile {
    public static void main(String[] args){
        PdfParser pdfParser = new PdfParser();
        pdfParser.setFilePath("/home/lara/Documents/extract.pdf");
        try{
            String text = pdfParser.toText();
            System.out.println(text);
        } catch (IOException e) {
            Logger.getLogger(PdfReadFromFile.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

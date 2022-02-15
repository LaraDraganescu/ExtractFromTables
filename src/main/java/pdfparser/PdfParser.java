package pdfparser;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.w3c.dom.Text;

public class PdfParser {

    private PDFParser parser; //extrage text from pdf
    private PDFTextStripper pdfTextStripper; //imparte pdf-ul (strip out)
    private PDDocument pdDocument; // creaza un pdf document gol
    private COSDocument cosDocument; //foloseste un file temporar ca sa depoziteze un pdf
    private String text;
    private String filePath;
    private File file;


    public PdfParser() {
    }

    public String toText() throws IOException{
        this.pdfTextStripper=pdfTextStripper;
        this.cosDocument=cosDocument;
        this.pdDocument=pdDocument;

        file=new File(filePath);
        parser=new PDFParser(new RandomAccessFile(file, "r")); //accesezi path-ul
        parser.parse();
        cosDocument=parser.getDocument(); //in file-ul temporar preiei documentul din path
        pdfTextStripper=new PDFTextStripper(); //creezi un obiect pdfStripper
        pdDocument=new PDDocument(cosDocument); // in pdf-ul gol se retine file-ul cu documentul preluat
        pdDocument.getNumberOfPages(); //preia numarul de pagini
        pdfTextStripper.setStartPage(0); //setezi ca start-ul extragerii textului sa fie de la pagina 0
        pdfTextStripper.setEndPage(pdDocument.getNumberOfPages()); //setezi ultima pagina sa fie extrasa, adica numarul paginii documentului preluat
        text=pdfTextStripper.getText(pdDocument); //preia textul din pdf
        return text;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public PDDocument getPdDoc() {
        return pdDocument;
    }
}

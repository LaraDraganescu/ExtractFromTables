package pdfparser;

import com.groupdocs.parser.Parser;
import com.groupdocs.parser.data.PageTableArea;
import com.groupdocs.parser.data.PageTableAreaCell;
import com.groupdocs.parser.options.PageTableAreaOptions;
import com.groupdocs.parser.templates.TemplateTableLayout;
import java.io.IOException;
import java.util.Arrays;

public class ExtractTablesFromPdf4 {
    public static void main(String[] args) throws IOException {
        try (Parser parser = new Parser("/home/lara/Documents/other_vendors/colonial/SDS/327225-01.pdf")) {
            // Check if the document supports table extraction
            if (!parser.getFeatures().isTables()) {
                System.out.println("Document isn't supports tables extraction.");
                return;
            }
            // Create the layout of tables
            TemplateTableLayout layout = new TemplateTableLayout(
                    Arrays.asList(new Double[]{50.0, 95.0, 275.0, 415.0, 485.0, 545.0}),
                    Arrays.asList(new Double[]{325.0, 340.0, 365.0, 395.0}));
            // Create the options for table extraction
            PageTableAreaOptions options = new PageTableAreaOptions(layout);
            // Extract tables from the document
            Iterable<PageTableArea> tables = parser.getTables(options);
            // Iterate over tables
            for (PageTableArea t : tables) {
                // Iterate over rows
                for (int row = 0; row < t.getRowCount(); row++) {
                    // Iterate over columns
                    for (int column = 0; column < t.getColumnCount(); column++) {
                        // Get the table cell
                        PageTableAreaCell cell = t.getCell(row, column);
                        if (cell != null) {
                            // Print the table cell text
                            System.out.print(cell.getText());
                            System.out.print(" | ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}

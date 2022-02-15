package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        ExtractMultipleFieldsFromDiffTables extract = new ExtractMultipleFieldsFromDiffTables();
//        List<String> word= List.of("Evaporation rate:","Form:","Ingredients");
//        extract.extraction("/home/lara/Documents/other_vendors/solvay/SDS/30078 - SDS.pdf", word);

        Extraction extract2 = new Extraction();
        List<Value> words= new ArrayList<>();
        Value value = new Value();
        value.setKey("STOT-SE");
        value.setPosition(Enum.RIGHT);
        words.add(value);
        System.out.println(extract2.extraction("/home/lara/Documents/other_vendors/westlake/SDS/GVC_Sodium_Hydroxide_Soln_50 (1).pdf", words));


//        ExtractOneFieldFromOneTable extractOneFieldFromOneTable = new ExtractOneFieldFromOneTable();
//        String field = "Form:";
//        extractOneFieldFromOneTable.extraction2("/home/lara/Documents/other_vendors/solvay/SDS/OR0476_OR0476_USENG.pdf",field);
    }
}

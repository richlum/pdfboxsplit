import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class CustomSplitter extends Splitter{
    String srcFile;
    PDDocument document;
    int[] pageToSplit;

    CustomSplitter(String srcFile, int[] destFilePageSizes){
        srcFile = srcFile;
//        document = PDDocument.load(file);
//        System.out.println("total pages: " + document.getNumberOfPages());

    }





}

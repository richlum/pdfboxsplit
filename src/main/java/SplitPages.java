import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class SplitPages {

    public static void main(String[] args) throws IOException{
        File file = new File("rsc/ABL_Classes_Notes.pdf");
        PDDocument document = PDDocument.load(file);

        Splitter splitter = new Splitter();

        List<PDDocument> Pages = splitter.split(document);

        Iterator<PDDocument> iterator = ((List) Pages).listIterator();

        int i = 1;
        while(iterator.hasNext()){
            PDDocument pd = iterator.next();
            pd.save("rsc/output" + i++ + ".pdf");
        }
        System.out.println("multiple pdfs created");
        document.close();

    }
}

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class SplitPages {


    public static void main(String[] args) throws IOException{
        if (args.length<2){
            System.out.println("usage: SplitPages sourcefile.pd \"csvListOfPagesPerOutputDocuments\"");
            return;
        }

        File file = new File("rsc/ABL_Classes_Notes.pdf");
        PDDocument document = PDDocument.load(file);
        System.out.println("total pages: " + document.getNumberOfPages());

        Integer[] pagesToSplitOn = {2,3,6,8,13,20};
        AtomicReference<List<Integer>> listPagesToSplit = new AtomicReference<>(Arrays.asList(pagesToSplitOn));
        Splitter splitter = new Splitter(){
            @Override
            protected boolean splitAtPage(int pageNumber){
                System.out.println(listPagesToSplit.get().contains(pageNumber));
                return listPagesToSplit.get().contains(pageNumber);
            }
        };
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

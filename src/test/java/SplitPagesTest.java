import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SplitPagesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void main() throws IOException {
        String splitOnPageStr = "2,4,7,14,19";
        String srcDoc = "rsc/ABL_Classes_Notes.pdf";
        List<Integer> pagesPerDoc = SplitPages.main(new String[]{ srcDoc, splitOnPageStr});
        pagesPerDoc.stream().forEach( pagect -> System.out.println( pagect ) );
    }
}
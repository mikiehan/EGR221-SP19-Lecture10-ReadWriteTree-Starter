import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by mhan on 2/25/2017.
 */
public class WriteTreeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    private void writeTestHelper(IntTreeNode root, String expectedStr) {
        IntTree testTree = new IntTree(root);
        testTree.writeTree();
        Assert.assertTrue(expectedStr.equals(outContent.toString()));
    }

    @Test
    public void writeTreeTest1(){
        IntTreeNode root = new IntTreeNode(7,
                                new IntTreeNode(9,
                                                new IntTreeNode(5),
                                                null),
                                new IntTreeNode(8,
                                                new IntTreeNode(4, null, new IntTreeNode(9)),
                                                new IntTreeNode(6)));
        String expected ="3 7"+System.lineSeparator()+"1 9"+System.lineSeparator()+"0 5"+System.lineSeparator()+"3 8"+System.lineSeparator()+"2 4"+System.lineSeparator()+"0 9"+System.lineSeparator()+"0 6"+System.lineSeparator();
        writeTestHelper(root, expected);
    }

    @Test
    public void writeTreeTest2(){
        IntTreeNode root = new IntTreeNode(1,
                                           new IntTreeNode(2,
                                                           new IntTreeNode(3,
                                                                           new IntTreeNode(4), null), null), null);
        String expected ="1 1"+System.lineSeparator()+"1 2"+System.lineSeparator()+"1 3"+System.lineSeparator()+"0 4"+System.lineSeparator();
        writeTestHelper(root, expected);
    }

    @Test
    public void writeTreeTest3(){
        IntTreeNode root = new IntTreeNode(1, null,
                                              new IntTreeNode(2, null,
                                                                 new IntTreeNode(3, null,
                                                                                    new IntTreeNode(4))));
        String expected ="2 1"+System.lineSeparator()+"2 2"+System.lineSeparator()+"2 3"+System.lineSeparator()+"0 4"+System.lineSeparator();
        writeTestHelper(root, expected);
    }

    @Test
    public void writeTreeTest4(){
        IntTreeNode root = new IntTreeNode(1, new IntTreeNode(2),
                                              new IntTreeNode(3, null,
                                                                 new IntTreeNode(4,
                                                                                 new IntTreeNode(5),
                                                                                 new IntTreeNode(6))));
        String expected ="3 1"+System.lineSeparator()+"0 2"+System.lineSeparator()+"2 3"+System.lineSeparator()+"3 4"+System.lineSeparator()+"0 5"+System.lineSeparator()+"0 6"+System.lineSeparator();
        writeTestHelper(root, expected);
    }


    @Test
    public void writeTreeTest5(){
        IntTreeNode root = new IntTreeNode(1, new IntTreeNode(2, new IntTreeNode(4,
                                                                                 new IntTreeNode(5),
                                                                                 new IntTreeNode(6)),
                                                                 null),
                                              new IntTreeNode(3));
        String expected ="3 1"+System.lineSeparator()+"1 2"+System.lineSeparator()+"3 4"+System.lineSeparator()+"0 5"+System.lineSeparator()+"0 6"+System.lineSeparator()+"0 3"+System.lineSeparator();
        writeTestHelper(root, expected);
    }

    @Test
    public void writeTreeTest6(){
        IntTreeNode root = new IntTreeNode(1,
                new IntTreeNode(2, null,
                                   new IntTreeNode(3,
                                                     new IntTreeNode(4,
                                                                     null,
                                                                     new IntTreeNode(5, new IntTreeNode(6), null))
                                                     , null)),
                null);
        String expected ="1 1"+System.lineSeparator()+"2 2"+System.lineSeparator()+"1 3"+System.lineSeparator()+"2 4"+System.lineSeparator()+"1 5"+System.lineSeparator()+"0 6"+System.lineSeparator();
        writeTestHelper(root, expected);
    }

    @Test
    public void writeTreeTest7(){
        IntTreeNode root = new IntTreeNode(12);
        String expected ="0 12"+System.lineSeparator();
        writeTestHelper(root, expected);
    }

    @Test
    public void writeTreeTest8(){
        String expected ="";
        writeTestHelper(null, expected);
    }

   @Test
    public void writeTreeTest9(){
        IntTreeNode root = new IntTreeNode(1,
                new IntTreeNode(2,
                        new IntTreeNode(4, new IntTreeNode(8), new IntTreeNode(9)),
                        new IntTreeNode(5, new IntTreeNode(10), new IntTreeNode(11))),
                new IntTreeNode(3,
                        new IntTreeNode(6, new IntTreeNode(12), new IntTreeNode(13)),
                        new IntTreeNode(7, new IntTreeNode(14), new IntTreeNode(15))
                        ));
        String expected ="3 1"+System.lineSeparator()+"3 2"+System.lineSeparator()+"3 4"+System.lineSeparator()+"0 8"+System.lineSeparator()+"0 9"+System.lineSeparator()+"3 5"+System.lineSeparator()+"0 10"+System.lineSeparator()+"0 11"+System.lineSeparator()+"3 3"+System.lineSeparator()+"3 6"+System.lineSeparator()+"0 12"+System.lineSeparator()+"0 13"+System.lineSeparator()+"3 7"+System.lineSeparator()+"0 14"+System.lineSeparator()+"0 15"+System.lineSeparator();
        writeTestHelper(root, expected);
    }

}

import org.junit.Assert;
import org.junit.Test;
import java.util.Scanner;

/**
 * Created by mhan on 2/25/2017.
 */
public class ReadTreeTest {

    private void readTestHelper(IntTreeNode expectedRoot, String inputStr){
        IntTree expectedTree = new IntTree(expectedRoot);
        IntTree testTree = new IntTree();
        testTree.readTree(new Scanner(inputStr));

        Assert.assertTrue(expectedTree.equals(testTree));
    }

    @Test
    public void readTreeTest1(){
        IntTreeNode expectedRoot = new IntTreeNode(7,
                new IntTreeNode(9,
                        new IntTreeNode(5),
                        null),
                new IntTreeNode(8,
                        new IntTreeNode(4, null, new IntTreeNode(9)),
                        new IntTreeNode(6)));
        String inputStr = "3 7"+System.lineSeparator()+"1 9"+System.lineSeparator()+"0 5"+System.lineSeparator()+"3 8"+System.lineSeparator()+"2 4"+System.lineSeparator()+"0 9"+System.lineSeparator()+"0 6"+System.lineSeparator();
        readTestHelper(expectedRoot, inputStr);
    }

    @Test
    public void readTreeTest2(){
        IntTreeNode expectedRoot = new IntTreeNode(1,
                new IntTreeNode(2,
                        new IntTreeNode(3,
                                new IntTreeNode(4), null), null), null);
        String inputStr ="1 1"+System.lineSeparator()+"1 2"+System.lineSeparator()+"1 3"+System.lineSeparator()+"0 4"+System.lineSeparator();
        readTestHelper(expectedRoot, inputStr);
    }

    @Test
    public void readTreeTest3(){
        IntTreeNode expectedRoot = new IntTreeNode(1, null,
                new IntTreeNode(2, null,
                        new IntTreeNode(3, null,
                                new IntTreeNode(4))));
        String inputStr ="2 1"+System.lineSeparator()+"2 2"+System.lineSeparator()+"2 3"+System.lineSeparator()+"0 4"+System.lineSeparator();
        readTestHelper(expectedRoot, inputStr);
    }


    @Test
    public void readTreeTest4(){
        IntTreeNode expectedRoot = new IntTreeNode(1, new IntTreeNode(2),
                new IntTreeNode(3, null,
                        new IntTreeNode(4,
                                new IntTreeNode(5),
                                new IntTreeNode(6))));
        String inputStr ="3 1"+System.lineSeparator()+"0 2"+System.lineSeparator()+"2 3"+System.lineSeparator()+"3 4"+System.lineSeparator()+"0 5"+System.lineSeparator()+"0 6"+System.lineSeparator();
        readTestHelper(expectedRoot, inputStr);
    }

    @Test
    public void readTreeTest5(){
        IntTreeNode expectedRoot = new IntTreeNode(1, new IntTreeNode(2, new IntTreeNode(4,
                new IntTreeNode(5),
                new IntTreeNode(6)),
                null),
                new IntTreeNode(3));
        String inputStr ="3 1"+System.lineSeparator()+"1 2"+System.lineSeparator()+"3 4"+System.lineSeparator()+"0 5"+System.lineSeparator()+"0 6"+System.lineSeparator()+"0 3"+System.lineSeparator();
        readTestHelper(expectedRoot, inputStr);
    }

    @Test
    public void readTreeTest6(){
        IntTreeNode expectedRoot = new IntTreeNode(1,
                new IntTreeNode(2, null,
                        new IntTreeNode(3,
                                new IntTreeNode(4,
                                        null,
                                        new IntTreeNode(5, new IntTreeNode(6), null))
                                , null)),
                null);
        String inputStr ="1 1"+System.lineSeparator()+"2 2"+System.lineSeparator()+"1 3"+System.lineSeparator()+"2 4"+System.lineSeparator()+"1 5"+System.lineSeparator()+"0 6"+System.lineSeparator();
        readTestHelper(expectedRoot, inputStr);
    }

    @Test
    public void readTreeTest7(){
        IntTreeNode expectedRoot = new IntTreeNode(12);
        String inputStr ="0 12"+System.lineSeparator();
        readTestHelper(expectedRoot, inputStr);
    }

    @Test
    public void readTreeTest8(){
        String inputStr ="";
        readTestHelper(null, inputStr);
    }

    @Test
    public void readTreeTest9(){
        IntTreeNode expectedRoot = new IntTreeNode(1,
                new IntTreeNode(2,
                        new IntTreeNode(4, new IntTreeNode(8), new IntTreeNode(9)),
                        new IntTreeNode(5, new IntTreeNode(10), new IntTreeNode(11))),
                new IntTreeNode(3,
                        new IntTreeNode(6, new IntTreeNode(12), new IntTreeNode(13)),
                        new IntTreeNode(7, new IntTreeNode(14), new IntTreeNode(15))
                ));
        String inputStr ="3 1"+System.lineSeparator()+"3 2"+System.lineSeparator()+"3 4"+System.lineSeparator()+"0 8"+System.lineSeparator()+"0 9"+System.lineSeparator()+"3 5"+System.lineSeparator()+"0 10"+System.lineSeparator()+"0 11"+System.lineSeparator()+"3 3"+System.lineSeparator()+"3 6"+System.lineSeparator()+"0 12"+System.lineSeparator()+"0 13"+System.lineSeparator()+"3 7"+System.lineSeparator()+"0 14"+System.lineSeparator()+"0 15"+System.lineSeparator();
        readTestHelper(expectedRoot, inputStr);
    }
}

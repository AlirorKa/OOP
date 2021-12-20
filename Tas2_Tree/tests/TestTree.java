package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Tree;


public class TestTree {

    Tree<Integer> tr1 = new Tree<>(10, null);
    Tree<Integer> tr2 = new Tree<>(33, null);

    @Test
    public void DeleteDoesntExistElement() throws Exception {
        Assertions.assertFalse(tr1.remove(21));

//        Assertions.assertEquals(35, tr1.left());
//        Assertions.assertEquals(5, tr1.left().left());
//        Assertions.assertEquals(17, tr1.right().left());
    }

    @Test
    public void SearchEements() throws Exception {
        tr1.add(5, 35, 1, 20, 4, 17, 31, 99, 18, 19, 2);

        tr1.search(10);
    }

}

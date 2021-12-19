package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.Tree;

public class Test_Tree {
    @Test
    public void DeleteRoot() {
        Tree<Integer> tr = new Tree<>(33, null);

        tr.add(5, 35, 1, 20, 4, 17, 31, 99, 18, 19);
        tr.remove(33);

        Assertions.assertEquals("35", tr.left().toString());
        Assertions.assertEquals(5, tr.left().left());
        Assertions.assertEquals(17, tr.right().left());
    }
/*

    @Test
    public void TestingTree() {
        Tree<String> tree = new Tree<>("string", 3);

        Assertions.assertTrue(tree.hasSpace());
        tree.add("another string", 1);
        tree.add("second branch", 0);
        tree.add("third branch", 0);

        Assertions.assertTrue(tree.hasSpace());
        Assertions.assertEquals(5, tree.getCount());
        Assertions.assertEquals(4, tree.getCurr());

        // This node will be placed in third level of tree
        tree.add("third level", 0);
        Assertions.assertFalse(tree.hasSpace());

        Assertions.assertArrayEquals(
                new Object[] {"string", "another string", "second branch", "third branch", "third level"},
                tree.toArray());

        // Removing all subtree
        tree.remove(1);
        Assertions.assertTrue(tree.hasSpace());

        Assertions.assertArrayEquals(
                new Object[] {"string", "second branch", "third branch"},
                tree.toArray());

        // New node will be placed in a first free(null) branch
        tree.add("instead of another string", 5);
        Assertions.assertTrue(tree.hasSpace());

        Assertions.assertArrayEquals(
                new Object[] {"string", "instead of another string", "second branch", "third branch"},
                tree.toArray());

        // Removing all tree
        tree.removeAll();
        Assertions.assertEquals(0, tree.getCount());
        Assertions.assertEquals(0, tree.getCurr());

        Assertions.assertArrayEquals(new Object[0], tree.toArray());

        // Adding new element after removeAll operation
        tree.add("the root", 10);
        Assertions.assertEquals(11, tree.getCount());
        Assertions.assertEquals(1, tree.getCurr());

        Assertions.assertArrayEquals(new Object[] {"the root"}, tree.toArray());

        // Adding collection of elements
        Collection<String> c = new ArrayList<>();
        c.add("Second");
        c.add("Third");
        c.add("Fourth");

        Assertions.assertEquals(3, tree.addAll(c, 2));
        Assertions.assertEquals(17, tree.getCount());
        Assertions.assertEquals(4, tree.getCurr());

        Assertions.assertArrayEquals(new Object[] {"the root", "Second", "Third", "Fourth"}, tree.toArray());
    }
*/


}

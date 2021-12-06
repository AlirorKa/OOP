package tests;

import main.java.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class tests {

    @Test
    void emptyStack() throws Exception{
        Stack<Integer> q = new Stack();

        Exception e = assertThrows(Exception.class, () -> {Integer a = (Integer) q.pop();});
        assertEquals(e.getMessage(),"Stack is empty");

        Exception e1 = assertThrows(Exception.class, () -> {Stack a =  q.popStack(3);});
        assertEquals(e1.getMessage(),"Stack is empty");
    }

    void notEnoughElements_popStack() throws Exception{
        Stack<Integer> q = new Stack();
        q.push(1);
        Exception e = assertThrows(Exception.class, () -> {Stack a =  q.popStack(3);});
        assertEquals(e.getMessage(),"Not enough elements in stack");
    }

    @Test
    void integerStack_1() throws Exception {
        Stack<Integer> q = new Stack();
        q.push((Integer)1);
        q.push((Integer)2);
        q.push((Integer)3);

        Integer x = (Integer) q.pop();
        assert (x == 3);

        x = q.pop();
        assert(x == 2);

        x = q.pop();
        assert(x == 1);
    }
    @Test
    void integerStack_2() throws Exception{
        Stack<Integer> q = new Stack();
        Stack<Integer> a = new Stack();
        Integer x;
        q.push((Integer)1);
        q.push((Integer)2);
        q.push((Integer)3);

        a = q.popStack(2);
        assert(a.count()==2 && q.count()==1);

        x = q.pop();
        assert(x == 1);
        q.push(x);

        x = q.pop();
        assert(x == 3);
        a.push(x);

        q.pushStack(a);
        assert(q.count()==3);

        x = q.pop();
        assert(x == 3);
    }

    @Test
    void stringStack() throws Exception {
        Stack<String> q = new Stack();

        q.push((String)"1");
        q.push((String)"2");
        q.push((String)"3");

        String x = (String) q.pop();
        assert (x == "3");

        x = q.pop();
        assert(x == "2");

        x = q.pop();
        assert(x == "1");
    }


}
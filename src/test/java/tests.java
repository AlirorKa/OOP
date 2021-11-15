import org.junit.jupiter.api.Test;
import project.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class tests {

    @Test
    void empty_Stack_test() throws Exception{
        Main q = new Main();   

        Exception e = assertThrows(Exception.class, () -> {Integer a = (Integer) q.pop();});
        assertEquals(e.getMessage(),"Stack is empty");

        Exception e1 = assertThrows(Exception.class, () -> {stack a =  q.popStack(3);});
        assertEquals(e1.getMessage(),"Stack is empty");
    }

    void pop_stack_test() throws Exception{
        stack<Integer> q = new stack();
        q.push(1);
        Exception e = assertThrows(Exception.class, () -> {stack a =  q.popStack(3);});
        assertEquals(e.getMessage(),"Not enough elements in stack");
    }

    @Test
    void func_working_Integer_test() throws Exception {
        stack<Integer> q = new stack();
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
    void func2_working_Integer_test() throws Exception{
        stack<Integer> q = new stack();
        stack<Integer> a = new stack();
        Integer x;
        q.push((Integer)1);
        q.push((Integer)2);
        q.push((Integer)3);

        a = q.popStack(2);
        assert(a.count()==2 && s.count()==1);

        x = q.pop();
        assert(x == 1);
        s.push(x);

        x = q.pop();
        assert(x == 3);
        a.push(x);

        q.pushStack(a);
        assert(s.count()==3);

        x = q.pop();
        assert(x == 3);
    }

    @Test
    void func_working_String_test() throws Exception {
        stack<String> q = new stack();

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

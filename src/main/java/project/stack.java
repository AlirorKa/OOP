package project;

import java.util.*;

public class stack<T> {

    private int size = 0;
    private int top = -1;
    private T[] arr = ((T[]) new Object[0]);


    void copyArr(int len) {
        arr = Arrays.copyOf(arr, len);
    }

    /**
     *
     * @return стэк без последнего элемента
     * @throws Exception
     */
    public T pop() throws Exception {
        if (top < 0) {
            Exception e;
            throw e = new IndexOutOfBoundsException("Stack is empty");
        }
        top--;
        return (T) arr[top + 1];
    }

    /**
     *
     * @param v элемент, который нужно присоединить в стэк
     */
    public void push(T v) {
        top++;
        if (top == size) {
            copyArr(size = 2 * size + 1);
        }
        arr[top] = v;
    }

    /**
     *
     * @return
     */
    public int count() {
        return top + 1;
    }

    /**
     *
     * @param st стэк, который складывают с данным
     * @throws Exception
     */
    public void pushStack(stack st) throws Exception {
        int n = st.count();
        if (top + n >= size) {
            copyArr(size = 2 * size + n);
        }

        T[] buf = (T[]) new Object[n];

        for (int i = 0; i < n; i++) {
            buf[i] = (T) st.pop();
        }

        for (int i = 0; i < n; i++) {
            this.push(buf[n - i - 1]);
        }
    }

    /**
     *
     * @param n кол-во элементов в стеке, которые надо отцепить
     * @return новый стэк, без n элементов
     * @throws Exception
     */
    public stack popStack(int n) throws Exception {
        if (top < 0) {
            Exception e;
            throw e = new IndexOutOfBoundsException("Stack is empty");
        }

        if (top - n < 0) {
            Exception e;
            throw e = new IndexOutOfBoundsException("Not enough elements in stack");
        }

        int newTop = top - n;

        stack<T> ret = new stack();
        for (int i = 0; i < n; i++) {
            ret.push(this.arr[newTop + i + 1]);
            this.pop();
        }
        return ret;
    }
}

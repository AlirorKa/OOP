package tests;

import com.company.Main;

import java.io.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertArrayEquals;

public class tests {

    @Test
    public void reversedElementTest() {
        Main q = new Main();
        int[] input = {6, 5, 4, 3, 2, 1};
        int[] res = {1, 2, 3, 4, 5, 6};
        q.sort(input);
        assertArrayEquals(input, res);
    }

    @Test
    public void switchedElementTesr() {
        Main q = new Main();
        int[] input = {5, 6, 7, 8, 10, 9};
        int[] res = {1, 2, 3, 4, 5, 6};
        q.sort(input);
        assertArrayEquals(input, res);
    }

    @Test
    public void reanfomOrderTest() {
        Main q = new Main();
        int[] input = {4, 2, 3, 1, 6, 5};
        int[] res = {1, 2, 3, 4, 5, 6};
        q.sort(input);
        assertArrayEquals(input, res);
    }

    @Test
    public void sameElementTest() {
        Main q = new Main();
        int[] input = {8, 8, 8, 8, 8, 3};
        int[] res = {3, 8, 8, 8, 8, 8};
        q.sort(input);
        assertArrayEquals(input, res);
    }

    @Test
    public void negativeElementTest() {
        Main q = new Main();
        int[] arr_in = {5, -6, 4, 3, 2, 1};
        int[] res = {-6, 1, 2, 3, 4, 5};
        q.sort(arr_in);
        assertArrayEquals(arr_in, res);
    }
    @Test
    public void emptyArrTest() {
        Main q = new Main();
        int[] arr_in = {};
        int[] res = {};
        q.sort(arr_in);
        assertArrayEquals(arr_in, res);
    }

    @Test
    public void oneElemTest(){
        Main q = new Main();
        int[] arr = {1};
        int[] res = {1};
        q.sort(arr);
        Assertions.assertArrayEquals(arr, res);
    }

}

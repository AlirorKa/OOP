import algorithm.word;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class test {

    @Test
    public void fileIsEmpty() throws IOException, Word.NoStringFoundExeption {
        Word main = new Word();
        Word.NoStringFoundExeption e = assertThrows(Word.NoStringFoundExeption.class, () ->
        {Integer[] x = main.finding_word("", "test.txt");});
        assertEquals("The substring is empty",  e.getMessage());
    }

    @Test
    public void normalTest() throws IOException, Word.NoStringFoundExeption {
        Word main = new Word();
        Integer[] x = main.finding_word("hello I'm Jon. Hi I am Peter. There is a frog. Frog eats people. !", "test.txt");
        assert(x[0]==0);
    }

    @Test
    public void erorrString() throws IOException, Word.NoStringFoundExeption {
        Word main = new Word();
        Integer[] x = main.finding_word("Hi I am Peterr", "test.txt");
        Integer[] y = {};
        assertEquals(x,y);
    }

    @Test
    public void findInEmptyFile () throws IOException, Word.NoStringFoundExeption {
        Word main = new Word();
        Integer[] x  main.finding_word("hello", "test1.txt");
        Integer[] y = {};
        assertEquals(x,y);
    }

    @Test
    public void substringSring() throws IOException, Word.NoStringFoundExeption {
        Word main = new Word();
        Integer[] x = main.finding_word("aabaab", "test2.txt");
        assert(x[0]==0 && x[1]==10 && x[2]==13 && x[3]==16);
    }

    @Test
    public void fileNotFound() throws IOException {
        Word main = new Word();
        IOException e = assertThrows(IOException.class, () -> {Integer[] a = main.finding_word("hello", "testX.txt");});
        assertEquals("testX.txt (Не удается найти указанный файл)",  e.getMessage());
    }
}
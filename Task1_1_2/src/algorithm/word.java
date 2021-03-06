package algorithm;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.*;

class Word {

    public class NoStringFoundExeption extends Exception
    {
        public NoStringFoundExeption(String str, String message)
        {
            super(str + message);
        }
    }
    /**
     *
     * @param str искомая строка
     * @return pi-функция str (длина максимального префикса str для каждого символа искомой строки)
     */
    public int[] piFunc(String str) {
        int n = str.length();
        int[] pi = new int[n];
        pi[0] = 0;
        
        for (int i = 1; i < n; ++i) {
            int j = pi[i - 1];
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = pi[j-1];
            if (str.charAt(j) == str.charAt(i))
                ++j;
            pi[i] = j;
        }
        return pi;
    }

    /**
     *
     * @param str строка, которую требуется найти
     * @param text файл, в котором мы ищес строку
     * @return
     */
    public Integer[] finding_word(String str, String text) throws IOException, NoStringFoundExeption {

        BufferedReader bufferedReader = null;
        int [] p = null;
        int m = str.length();
        try {
            bufferedReader = new BufferedReader(new FileReader(text));
        } catch (FileNotFoundException e) {
            throw e;
        }
        
        if (m == 0){
            NoStringFoundExeption e = new NoStringFoundExeption(str, "The substring is empty");
            throw e;
        }
        
        p = piFunc(str);

        ArrayList<Integer> out = new ArrayList<Integer>();

        int sym = bufferedReader.read();
        int j = 0;
        int i;
        
        for (i = 0; sym != -1; i++) {
            char c = (char) sym;
            sym = bufferedReader.read();
            while (j > 0 && c != str.charAt(j))
                j = p[j - 1];
            if (c == str.charAt(j))
                j++;
            if (j == m) {
                out.add(i - j + 1);
                j = p[j - 1];

            }
        }
        Integer[] arr={};
        arr = (out.toArray(arr));
        return arr;
    }
}

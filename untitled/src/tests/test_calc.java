package tests;

import main.Calculator_R;
import main.Calculator_C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class test_calc {

    @Test
    public void TestAll() throws Exception {
        String[] test = new String[0];
        test = Arrays.copyOf(test, 13);

        test[0] = "sin + - 1 2 1";
        Assertions.assertEquals(0, Calculator_R.calculate(test[0]));

        test[1] = "- 9 2";
        Assertions.assertEquals(7, Calculator_R.calculate(test[1]));

        test[2] = "- * 15 4 / 6 3";
        Assertions.assertEquals(58, Calculator_R.calculate(test[2]));

        test[3] = "- * / 15 - 7 + 1 1 3 + 2 + 1 1";
        Assertions.assertEquals(5, Calculator_R.calculate(test[3]));

        test[4] = "/ / 30 5 / 90 3 ";
        Assertions.assertEquals(0.2, Calculator_R.calculate(test[4]));

        test[5] = "log cos - 15 / 30 2";
        Assertions.assertEquals(0, Calculator_R.calculate(test[5]));

        test[6] = "sqrt - 1088 pow 2 10";
        Assertions.assertEquals(8, Calculator_R.calculate(test[6]));

        test[7] = "sqrt sqrt 4096";
        Assertions.assertEquals(8, Calculator_R.calculate(test[7]));

        test[8] = "/ 4 - * 3 2 1";
        Assertions.assertEquals(0.8, Calculator_R.calculate(test[8]));

        test[9] = "- * 4 8 + 2 3";
        Assertions.assertEquals(27, Calculator_R.calculate(test[9]));

        test[10] = "* 7.4 + 13 - 20.5 10.5";
        Assertions.assertEquals(170.20000000000002, Calculator_R.calculate(test[10]));

        /*Exception e = new Exception();
        test[11] = "* 7.4 + 13 - 20.5 10.5 q";
        Assertions.assertEquals(e.getMessage(), "I don't know this symbol: q");

        test[11] = "* 7.4 + 13 ^ 20.5 10.5";
        Assertions.assertEquals(e.getMessage(), "I don't know this symbol: ^");*/
    }

    /*
    @Test
    public void TestComplex() throws Exception {
        String[] test = new String[0];
        test = Arrays.copyOf(test, 6);

        test[0] = "+ +1 +1i +1 +1i";
        Assertions.assertEquals(170.20000000000002, Calculator_C.calculate(test[0]));

        test[1] =;
        test[2] =;
        test[3] =;
        test[4] =;
        test[5] =;
*/

    }

}

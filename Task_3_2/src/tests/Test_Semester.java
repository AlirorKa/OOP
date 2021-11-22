package tests;

import main.Semester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_Semester {

    @Test
    public void Add_Subjects() throws Exception {
        Semester semestr = new Semester(12);
        String s = "a";
        for (int i = 0; i < semestr.getMAX_NUMBERS_OF_SUBJECTS(); i++) {
            semestr.addSubject(s, 0, false);
            s += "a";
        }
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            semestr.addSubject("b", 0, false);
        });

        Assertions.assertEquals("Слишком много предметов.", e.getMessage());

        Semester semestr2 = new Semester(12);
        e = Assertions.assertThrows(Exception.class, () -> {semestr2.addSubject("", 5, true);});
        Assertions.assertEquals("Неверные данные.", e.getMessage());

        e = Assertions.assertThrows(Exception.class, () -> {semestr2.addSubject(null, -5, true);});
        Assertions.assertEquals("Неверные данные.", e.getMessage());

        e = Assertions.assertThrows(Exception.class, () -> {semestr2.addSubject("Модели вычислений", -5, true);});
        Assertions.assertEquals("Неверные данные.", e.getMessage());
    }

    @Test
    public void Average_Grade() throws Exception {
        Semester semestr = new Semester(20);

        Assertions.assertEquals(0, semestr.getSubjectNumbers());
        Assertions.assertEquals(0, semestr.getAverageGrade());

        semestr.addSubject("Модели вычислений", 4, false);
        semestr.addSubject("Декларативное программирование", 4, false);
        semestr.addSubject("Операционные системы", 4, true);

        Assertions.assertEquals(3, semestr.getSubjectNumbers());
        Assertions.assertEquals(4, semestr.getAverageGrade());

        semestr.addSubject("Модели вычислений", 5, false);
        semestr.addSubject("Декларативное программирование", 5, false);
        semestr.addSubject("Операционные системы", 5, true);

        Assertions.assertEquals(3, semestr.getSubjectNumbers());
        Assertions.assertEquals(5, semestr.getAverageGrade());

        semestr.addSubject("ТЫ и МС", 4, false);
        semestr.addSubject("Физическая культура", 0, false);
        semestr.addSubject("Цифровые платформы", 4, true);
        semestr.addSubject("Введение в ИИ", 4, true);

        Assertions.assertEquals(7, semestr.getSubjectNumbers());
        Assertions.assertEquals(4.4,Math.round(semestr.getAverageGrade() * 10.0) / 10.0);
    }

    @Test
    public void isScholarship() throws Exception {
        Semester semestr = new Semester(12);

        semestr.addSubject("Модели вычислений", 4, false);
        semestr.addSubject("Декларативное программирование", 4, false);
        semestr.addSubject("Операционные системы", 4, true);

        Assertions.assertTrue(semestr.isScholarship());

        semestr.addSubject("Физическая культура", 0, false);
        semestr.addSubject("Цифровые платформы", 4, true);
        semestr.addSubject("Введение в ИИ", 4, true);

        Assertions.assertTrue(semestr.isScholarship());

        semestr.addSubject("Физическая культура", 3, true);

        Assertions.assertFalse(semestr.isScholarship());
    }

    @Test
    public void HonorsDegree() throws Exception {
        Semester semestr = new Semester(12);

        Exception e = Assertions.assertThrows(Exception.class, () -> { semestr.getGreatGrades();});
        Assertions.assertEquals("Нету предметов.", e.getMessage());

        semestr.addSubject("Квалифицированная работа", 0, true);
        semestr.addSubject("Декларативное программирование", 5, true);
        semestr.addSubject("Цифровые платформы", 5, true);
        semestr.addSubject("Операционные системы", 4, true);
        semestr.addSubject("Введение в ИИ", 4, true);

        Assertions.assertEquals(2, semestr.getGreatGrades());

        semestr.addSubject("Квалифицированная работа", 4, true);

        Assertions.assertEquals(0, semestr.getGreatGrades());
    }
}

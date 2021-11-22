package tests;
import main.Semester;
import main.StudentBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_SB {

    @Test
    public void AddingSemesters() throws Exception {
        StudentBook stBooK = new StudentBook(10);
        Exception e;

        e = Assertions.assertThrows(Exception.class, () -> {
            for (int i = 0; i < stBooK.getMAX_SEMESTERS() + 1; i++) {
                stBooK.addSemester(12);
            }
        });
        Assertions.assertEquals("Слишком много семестров.", e.getMessage());

        e = Assertions.assertThrows(Exception.class, () -> {
            StudentBook b = new StudentBook(-20);
        });
        Assertions.assertEquals("Номер семестра не может быть отрицательным. ", e.getMessage());
    }

    @Test
    public void Add_Subject() throws Exception {
        StudentBook stBooK = new StudentBook(10);
        Exception e;

        stBooK.addSemester(12);

        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.addSubject(-1, "ТВ и МС", 5, false);
        });
        Assertions.assertEquals("Семестра не существует.", e.getMessage());

        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.addSubject(1, "", 3, false);
        });
        Assertions.assertEquals("Неверные данные.", e.getMessage());

        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.addSubject(1, null, 3, false);
        });
        Assertions.assertEquals("Неверные данные.", e.getMessage());

        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.addSubject(1, "ТВ и МС", 25, false);
        });
        Assertions.assertEquals("Неверные данные.", e.getMessage());

        stBooK.addSubject(1, "ТВ и МС", 5, false);
        stBooK.addSubject(1, "ДУ и ТФПК", 4, false);
        stBooK.addSubject(1, "ООП", 3, false);
        Assertions.assertEquals(3, stBooK.getSemester(1).getSubjectNumbers());
    }

    @Test
    public void AverageResult() throws Exception {
        StudentBook stBooK = new StudentBook(10);
        Exception e;

        stBooK.addSemester(12);

        stBooK.addSubject(1, "Разработка ПАК", 0, true);
        stBooK.addSubject(1, "Алгебра", 3, false);
        stBooK.addSubject(1, "Введение в математический анализ", 4, false);
        stBooK.addSubject(1, "Имперавное пограммирование", 5, false);
        stBooK.addSubject(1, "Английский", 4, false);
        stBooK.addSubject(1, "Физра", 5, true);
        stBooK.addSubject(1, "Основы культры речи", 5, true);

        Assertions.assertEquals(4.3, Math.round(stBooK.getAverageGrade() *  10.0) / 10.0 );

        stBooK.addSemester(12);

        stBooK.addSubject(2, "Разработка ПАК", 5, true);
        stBooK.addSubject(2, "Алгебра", 4, true);
        stBooK.addSubject(2, "Введение в математический анализ", 4, true);
        stBooK.addSubject(2, "Имперавное пограммирование", 5, true);
        stBooK.addSubject(2, "Английский", 5, false);
        stBooK.addSubject(2, "Физра", 4, false);
        stBooK.addSubject(2, "Основы культры речи", 5, true);

        Assertions.assertEquals(4.4, Math.round(stBooK.getAverageGrade() *  10.0) / 10.0 );
    }

    @Test
    public void Scholarship() throws Exception {
        StudentBook stBooK = new StudentBook(10);
        Exception e;

        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.isScholarship(1);
        });
        Assertions.assertEquals("Неверный номер семестра", e.getMessage());

        stBooK.addSubject(1, "Разработка ПАК", 0, true);
        stBooK.addSubject(1, "Алгебра", 3, false);
        stBooK.addSubject(1, "Введение в математический анализ", 4, false);
        stBooK.addSubject(1, "Имперавное пограммирование", 5, false);
        stBooK.addSubject(1, "Английский", 4, false);
        stBooK.addSubject(1, "Физра", 5, true);
        stBooK.addSubject(1, "Основы культры речи", 5, true);

        Assertions.assertFalse(stBooK.isScholarship(1));

        stBooK.addSubject(2, "Разработка ПАК", 5, true);
        stBooK.addSubject(2, "Алгебра", 4, true);
        stBooK.addSubject(2, "Введение в математический анализ", 4, true);
        stBooK.addSubject(2, "Имперавное пограммирование", 5, true);
        stBooK.addSubject(2, "Английский", 5, false);
        stBooK.addSubject(2, "Физра", 4, false);
        stBooK.addSubject(2, "Основы культры речи", 5, true);

        Assertions.assertTrue(stBooK.isScholarship(2));
    }

    @Test
    public void HonorsDegree() throws Exception {
        StudentBook stBooK = new StudentBook(10);

        stBooK.addSemester(12);
        stBooK.addSubject(1, "Разработка ПАК", 0, true);
        stBooK.addSubject(1, "Алгебра", 3, false);
        stBooK.addSubject(1, "Введение в математический анализ", 4, false);
        stBooK.addSubject(1, "Имперавное пограммирование", 5, false);
        stBooK.addSubject(1, "Английский", 4, false);
        stBooK.addSubject(1, "Физра", 5, true);
        stBooK.addSubject(1, "Основы культры речи", 5, true);


        stBooK.addSemester(20);
        stBooK.addSubject(2, "Разработка ПАК", 5, true);
        stBooK.addSubject(2, "Алгебра", 4, true);
        stBooK.addSubject(2, "Введение в математический анализ", 4, true);
        stBooK.addSubject(2, "Имперавное пограммирование", 5, true);
        stBooK.addSubject(2, "Английский", 5, false);
        stBooK.addSubject(2, "Физра", 4, false);
        stBooK.addSubject(2, "Основы культры речи", 5, true);

        Assertions.assertFalse(stBooK.isHonorsDegree());

        stBooK.addSubject(1, "Алгебра", 5, false);
        stBooK.addSubject(2, "Алгебра", 5, true);
        stBooK.addSubject(2, "Введение в математический анализ", 5, true);

        Assertions.assertTrue(stBooK.isHonorsDegree());

        stBooK.addSubject(1, "Алгебра", 3, false);

        Assertions.assertFalse(stBooK.isHonorsDegree());
    }
}

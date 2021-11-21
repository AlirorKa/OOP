package tests;
import main.Semester;
import main.StudentBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStudentBook {

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
    public void AddingSubject() throws Exception {
        StudentBook stBooK = new StudentBook(10);
        Exception e;

        stBooK.addSemester(12);

        // Non-existent semester
        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.addSubject(-1, "Algebra", 5, false);
        });
        Assertions.assertEquals("Семестра не существует.", e.getMessage());

        // Incorrect parameters
        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.addSubject(1, "", 5, false);
        });
        Assertions.assertEquals("Неверные данные.", e.getMessage());

        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.addSubject(1, null, 5, false);
        });
        Assertions.assertEquals("Неверные данные.", e.getMessage());

        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.addSubject(1, "Algebra", 10, false);
        });
        Assertions.assertEquals("Неверные данные.", e.getMessage());

        stBooK.addSubject(1, "Algebra", 4, false);
        stBooK.addSubject(1, "Set Theory", 4, false);
        stBooK.addSubject(1, "Programming", 4, false);
        Assertions.assertEquals(3, stBooK.getSemester(1).getSubjectNumbers());
    }

    @Test
    public void AverageResult() throws Exception {
        StudentBook stBooK = new StudentBook(10);
        Exception e;

        stBooK.addSemester(20);

        stBooK.addSubject(1, "Project", 0, true);
        stBooK.addSubject(1, "Analysis", 3, false);
        stBooK.addSubject(1, "Discrete Math", 4, false);
        stBooK.addSubject(1, "Declarative Programming", 5, false);
        stBooK.addSubject(1, "Imperative Programming", 4, false);
        stBooK.addSubject(1, "History", 5, true);
        stBooK.addSubject(1, "Speech", 5, true);

        Assertions.assertEquals(4.3, Math.round(stBooK.getAverageResult() *  10.0) / 10.0 );

        stBooK.addSemester(20);

        stBooK.addSubject(2, "Project", 5, true);
        stBooK.addSubject(2, "Analysis", 4, true);
        stBooK.addSubject(2, "Discrete Math", 4, true);
        stBooK.addSubject(2, "Declarative Programming", 5, true);
        stBooK.addSubject(2, "Imperative Programming", 5, true);
        stBooK.addSubject(2, "English", 4, false);
        stBooK.addSubject(2, "Digital Platforms", 5, true);

        Assertions.assertEquals(4.4, Math.round(stBooK.getAverageResult() *  10.0) / 10.0 );
    }

    @Test
    public void Scholarship() throws Exception {
        StudentBook stBooK = new StudentBook(10);
        Exception e;

        e = Assertions.assertThrows(Exception.class, () -> {
            stBooK.isScholarship(1);
        });
        Assertions.assertEquals("Incorrect semester number", e.getMessage());

        stBooK.addSemester(20);
        stBooK.addSubject(1, "Project", 0, true);
        stBooK.addSubject(1, "Analysis", 3, false);
        stBooK.addSubject(1, "Discrete Math", 4, false);
        stBooK.addSubject(1, "Declarative Programming", 5, false);
        stBooK.addSubject(1, "Imperative Programming", 4, false);
        stBooK.addSubject(1, "History", 5, true);
        stBooK.addSubject(1, "Speech", 5, true);

        Assertions.assertFalse(stBooK.isScholarship(1));

        stBooK.addSemester(20);
        stBooK.addSubject(2, "Project", 5, true);
        stBooK.addSubject(2, "Analysis", 4, true);
        stBooK.addSubject(2, "Discrete Math", 4, true);
        stBooK.addSubject(2, "Declarative Programming", 5, true);
        stBooK.addSubject(2, "Imperative Programming", 5, true);
        stBooK.addSubject(2, "English", 4, false);
        stBooK.addSubject(2, "Digital Platforms", 5, true);

        Assertions.assertTrue(stBooK.isScholarship(2));
    }

    @Test
    public void HonorsDegree() throws Exception {
        StudentBook stBooK = new StudentBook(10);

        stBooK.addSemester(20);
        stBooK.addSubject(1, "Project", 0, true);
        stBooK.addSubject(1, "Analysis", 3, false);
        stBooK.addSubject(1, "Discrete Math", 4, false);
        stBooK.addSubject(1, "Declarative Programming", 5, false);
        stBooK.addSubject(1, "Imperative Programming", 4, false);
        stBooK.addSubject(1, "History", 5, true);
        stBooK.addSubject(1, "Speech", 5, true);

        stBooK.addSemester(20);
        stBooK.addSubject(2, "Project", 5, true);
        stBooK.addSubject(2, "Analysis", 4, true);
        stBooK.addSubject(2, "Discrete Math", 4, true);
        stBooK.addSubject(2, "Declarative Programming", 5, true);
        stBooK.addSubject(2, "Imperative Programming", 5, true);
        stBooK.addSubject(2, "English", 4, false);
        stBooK.addSubject(2, "Digital Platforms", 5, true);

        Assertions.assertFalse(stBooK.isHonorsDegree());

        stBooK.addSubject(1, "Analysis", 5, false);
        stBooK.addSubject(2, "Analysis", 5, true);
        stBooK.addSubject(2, "Discrete Math", 5, true);

        Assertions.assertTrue(stBooK.isHonorsDegree());

        stBooK.addSubject(1, "Analysis", 3, false);

        Assertions.assertFalse(stBooK.isHonorsDegree());
    }
}
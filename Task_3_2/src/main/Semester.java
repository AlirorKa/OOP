package main;

import java.util.ArrayList;

public class Semester {

    private ArrayList<Subject> subjects;

    private int MAX_NUMBERS_OF_SUBJECTS = 12;
    private int subNumbers;

    Semester(int maxSubjects) throws Exception {
        if (maxSubjects <= 0)
            throw new Exception("Subjects number can not be negative");

        subjects = new ArrayList<>();
        subNumbers = 0;
    }

    /**
     * @return - макс кол-во предметов
     */
    public int getMAX_NUMBERS_OF_SUBJECTS() {
        return MAX_NUMBERS_OF_SUBJECTS;
    }

    /**
     * @return - кол-во предметов
     */
    public int getSubjectNumbers() {

        return subNumbers;
    }
    /**
     * @return - получить номер последнего записанного предмета
     */
    public int getLastNumber() {
        int number = 0;
        for (int i = 1; i < subNumbers; i++)
            if (subjects.get(i).isLast())
                number++;

        return number;
    }

    /**
     * @param sub - наименование предмета
     * @param grade - оценка 0/5
     * @param last - если значение 0, то предмет не послежний в семестре
     * @throws Exception - если наименование пустое или null, оценка отрицательная или больше 5, или попытка добавить предметов больше, чем MAX_NUMBERS_OF_SUBJECTS
     */
    public void addSubject(String sub, int grade, boolean last) throws Exception {
        if (sub == null ||
                sub.equals("") ||
                    grade < 0 || grade > 5)
            throw new Exception("Неверные данные.");

        int index = -1;
        for(Subject s : subjects) {
            if (s.getSub().equals(sub))
                index = subjects.indexOf(s);
        }

        if (index >= 0) {
            subjects.get(index).setGrade(grade);
            subjects.get(index).setLast(last);
        }
        else {
            if (subNumbers >= MAX_NUMBERS_OF_SUBJECTS)
                throw new Exception("Больше нельзя добавить предметов.");
            subjects.add(new Subject(sub, grade, last));
            subNumbers++;
        }
    }

    /**
     * @return - средний балл
     */
    public float getAverageGrade() {
        float res = 0;
        int count = 0;
        int tmp;

        for (int i = 1; i < subNumbers; i++) {
            if ((tmp = subjects.get(i).getGrade()) != 0) {
                res += tmp;
                count++;
            }
        }

        if (count <= 0) return 0;

        return res / count;
    }

    /**
     * @return - true если можно поучить степендию
     */
    public boolean isScholarship() {
        boolean solarShip = true;
        int tmp;

        for (int i = 0; i < subNumbers; i++) {
            tmp = subjects.get(i).getGrade();

            if (tmp < 4 && tmp > 0) {
                solarShip = false;
                break;
            }
        }
        return solarShip;
    }

    /**
     * @return - счётчик пятёрок
     * @throws Exception - нету предметов
     */
    public int getGreatGrades() throws Exception {
        if (subNumbers <= 0)
            throw new Exception("Нету предметов.");

        int great = 0;
        int tmp = subjects.get(0).getGrade();
        if (tmp == 5 || tmp == 0) {
            for (int i = 1; i < subNumbers; i++) {
                if ((tmp = subjects.get(i).getGrade()) < 4 && tmp != 0) {
                    great = -1;
                    break;
                }
                else if (subjects.get(i).isLast() && tmp == 5)
                    great++;
            }
        }

        return great;
    }
}
package main;

import java.util.ArrayList;

public class StudentBook {
    private ArrayList<Semester> semester;

    private int MAX_NUMBER_OF_SEMESTERS;
    private int semNumbers;

    StudentBook(int max_num_of_Semesters) throws Exception {
        if (max_num_of_Semesters <= 0)
            throw new Exception("Кол-во семестров не может быть отрицательным.");

        semester = new ArrayList<>();
        MAX_NUMBER_OF_SEMESTERS = max_num_of_Semesters;
        semNumbers = 0;
    }

    /**
     * @return - макс вол-во семестров
     */
    public int getMAX_SEMESTERS() {
        return MAX_NUMBER_OF_SEMESTERS;
    }

    /**
     * @return - кол-во семестров
     */
    public int getSemesterNumbers() {
        return semNumbers;
    }

    /**
     * @param maxSubjects - макс кол-во предметов в семестре
     * @throws Exception - если добавляют больше , чем макс кол-во семестров MAX_NUMBER_OF_SEMESTERS
     */
    public void addSemester(int maxSubjects) throws Exception {
        if (semNumbers >= MAX_NUMBER_OF_SEMESTERS)
            throw new Exception("Слмшком много семестров.");

        if (maxSubjects <= 0)
            throw new Exception("Кол-во предметов не может бвть отрицательным.");

        semester.add(new Semester(maxSubjects));
        ++semNumbers;
    }

    /**
     * @param semNum - номер семестра
     * @return - семестр по semNum
     * @throws Exception - если пытаются добавить семемстр больше, чем возможно
     */
    public Semester getSemester(int semNum) throws Exception {
        if (semNum <= 0 || semNum > semNumbers)
            throw new Exception("Семестра не существует.");

        return semester.get(semNum - 1);
    }

    /**
     * @param semNum - номер семестра
     * @param sub - название предмета
     * @param grade - оценка 0/5
     * @param last - является ли семестр этого предмета последним
     * @throws Exception - сли пытаются добавить в семемстр больше, чем возможно
     */
    public void addSubject(int semNum, String sub, int grade, boolean last) throws Exception {
        if (semNum <= 0 || semNum > semNumbers)
            throw new Exception("Семестра не существует.");

        if (sub == null || sub.equals("") ||
                grade < 0 || grade > 5)
            throw new Exception("Неверные данные.");

        semester.get(semNum - 1).addSubject(sub, grade, last);
    }

    /**
     * @return - средний результат по всем предметам по семестрам
     */
    public float getAverageGrade() {
        float sum = 0;
        int count = 0;
        float tmp;

        for (int i = 0; i < semNumbers; i++) {
            if ((tmp = semester.get(i).getAverageGrade()) > 0) {
                sum += tmp;
                ++count;
            }
        }

        if (count <= 0)
            return 0;

        return sum / count;
    }

    /**
     * @param semNum - номер семестра
     * @return - true если возможно получить степендию
     * @throws Exception - throws when try to index by Semester which not in range
     */
    public boolean isScholarship(int semNum) throws Exception {
        if (semNum <= 0 || semNum > semNumbers)
            throw new Exception("Неверный номер семестра.");

        return semester.get(semNum - 1).isScholarship();
    }

    /**
     * @return - true if it is possible to get Hons
     * @throws Exception - throws if there are no subjects
     */
    public boolean isHonorsDegree() throws Exception {
        boolean hons = true;
        int great = 0;
        int count = 0;
        int tmp;

        for (int i = 0; i < semNumbers; i++) {
            if ((tmp = semester.get(i).getGreatGrades()) < 0) {
                hons = false;
                break;
            }
            else if (tmp > 0) {
                great += tmp;
                count += semester.get(i).getLastNumber();
            }
        }

        if ((count != 0) && (((float) great / (float) count) * 100 < 75.0))
            hons = false;

        return hons;
    }
}
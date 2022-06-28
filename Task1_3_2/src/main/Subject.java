package main;

public class Subject {

    private String sub;
    private int grade;
    private boolean last;

    Subject(String sub, int grade, boolean last) throws Exception
    {
        if (sub == null ||
                sub.equals("") ||
                    grade < 0 || grade > 5)
            throw new Exception("Неверные данные.");

        this.sub = sub;
        this.grade = grade;
        this.last = last;
    }

    public String getSub() {
        return sub;
    }
    public int getGrade() {
        return grade;
    }
    public boolean isLast() {
        return last;
    }

    public void setName(String sub) throws Exception {
        if (sub == null || sub.equals(""))
            throw new Exception("Неверные данные.");

        this.sub = sub;
    }

    public void setGrade(int grade) throws Exception {
        if (grade < 0 || grade > 5)
            throw new Exception("Неверные данные.");
        this.grade = grade;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
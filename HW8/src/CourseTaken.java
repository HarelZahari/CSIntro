/*
 
 Assignment number     :    8
 
 File Name             :    CourseTaken.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
/**
 * Represents pairs of Course object and grade.
 */
public class CourseTaken {

    private Course course;
    private int grade;

    /**
     * constructs a new CourseTaken instance.
     * 
     * @param c
     *            the taken course
     * @param grade
     *            the grade in the course
     */
    public CourseTaken(Course c, int grade) {
        this.course = c;
        this.grade = grade;
    }

    /**
     * returns the Course object of this CourseTaken instance.
     * 
     * @return the Course object of this CourseTaken instance.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * returns the grade this CourseTaken instance.
     * 
     * @return the grade of this CourseTaken instance.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Set a grade to CourseTaken
     * 
     * @param grade
     *            the grade for set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * A textual representation of this CourseTaken instance.
     */
    public String toString() {
        return course.toString() + ", grade: " + grade;
    }
}

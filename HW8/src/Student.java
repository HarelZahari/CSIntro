/*
 
 Assignment number     :    8
 
 File Name             :    Student.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
import linkedList.*;

/**
 * Represents a student.
 */
public class Student {

    private int sid;
    private String name;
    private LinkedList<CourseTaken> courseList;

    /**
     * Constructs a new student with the given sid and name, and an empty course
     * list.
     * 
     * @param sid
     *            the student's sid
     * @param name
     *            the student's name
     */
    public Student(int sid, String name) {
        this.sid = sid;
        this.name = name;
        courseList = new LinkedList<CourseTaken>();
    }

    /**
     * Returns the sid of this student.
     * 
     * @return the sid of this student.
     */
    public int getSid() {
        return sid;
    }

    /**
     * Returns the name of this student.
     * 
     * @return the name of this student.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the size of this student, courseList size.
     * 
     * @return the size of this courseTaken list.
     */
    public int getCourseTakenSize() {
        return courseList.size();
    }
    
    /**
     * Adds the given course and grade to the course list of this student.
     * 
     * @param c
     *            the course to add
     * @param grade
     *            the grade in the added course
     */
    public void addCourse(Course c, int grade) {
        if (!tookCourse(c)) {
            this.courseList.add(new CourseTaken(c, grade));
        }else {
            boolean isFound=false;
            ListIterator<CourseTaken> courseListIter = this.courseList.iterator();
            while(courseListIter.hasNext() && !isFound) {
                CourseTaken currentCourseTaken=courseListIter.next();
                if(currentCourseTaken.getCourse().equals(c)) {
                    currentCourseTaken.setGrade(grade);
                }
            }
        }
    }

    /**
     * Remove the given course from this student courseTaken list.
     * 
     * @param c
     *            the course to remove
     */
    public void removeCourse(Course c) {
        ListIterator<CourseTaken> courseTakenIter=this.courseList.iterator();
        while(courseTakenIter.hasNext()) {
            CourseTaken courseTaken=courseTakenIter.next();
            if(courseTaken.getCourse().equals(c)){
                this.courseList.remove(courseTaken);
            }
        }
    }

    
    /**
     * Returns the grade that this student got in the given course, or -1 if the
     * course was not taken by this student.
     * 
     * @param c
     *            - the returned grade will be the grade in this course.
     * @return the grade that this student got in the given course
     */
    public int gradeInCourse(Course c) {
            ListIterator<CourseTaken> courseListIter=this.courseList.iterator();
            while (courseListIter.hasNext()) {
                CourseTaken currentCourseTaken=courseListIter.next();
                if(currentCourseTaken.getCourse().equals(c)) {
                    return currentCourseTaken.getGrade();
                }
            }
            return -1;
        }

    /**
     * Returns true if this student took the given course, false otherwise.
     * 
     * @param c
     *            the course we want to know whether or not the student took.
     * @return true if this student took the given course, false otherwise.
     */
    public boolean tookCourse(Course c) {
        return this.gradeInCourse(c) != -1; 
    }

    /**
     * Prints this student, all the courses that s/he took, and the grade point
     * average.
     */
    public void studentReport() {
        int studentAverage=0;
        int i;
        ListIterator<CourseTaken> courseListIter=this.courseList.iterator();
        System.out.println(this.getName()+":");
        for (i=0;courseListIter.hasNext();i++) {
            CourseTaken currentCourseTaken=courseListIter.next();
            Course currentCourse=currentCourseTaken.getCourse();
            System.out.println("Course "+currentCourse.getCid()+": "+currentCourse.getTitle()+", grade: "+currentCourseTaken.getGrade());
            studentAverage+=currentCourseTaken.getGrade();
        }
        System.out.println("Grade average: "+studentAverage/i);
    }
    
    /**
     * Textual representation of this student.
     */
    public String toString() {
        return "Student " + sid + ": " + name;
    }
}
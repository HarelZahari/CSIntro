/*
 
 Assignment number     :    8
 
 File Name             :    College.java
 
 Name (First Last)     :    Harel Zahari
 
 Student ID            :    305494452
 
 Email                 :    harel.zahari@post.idc.ac.il
 
 */
import linkedList.*;

/**
 * Represents a college, and college management operations. A college has
 * courses, and students. Students take courses and get grades. (See the Course,
 * Student, and CourseTaken classes for more details).
 */
public class College {

    private static String nl = System.getProperty("line.separator");

    private String name; // the name of this college
    private LinkedList<Course> courses;
    private LinkedList<Student> students;

    /**
     * Constructs a new college, with empty student and course lists.
     */
    public College(String name) {
        this.name = name;
        this.courses = new LinkedList<Course>();
        this.students = new LinkedList<Student>();
    }

    /**
     * Adds the given course to the course list of this college.
     * 
     * @param cid
     *            course id.
     * @param title
     *            course title.
     */
    public void addCourse(int cid, String title) {
        boolean isFound = false;
        ListIterator<Course> courseIter = this.courses.iterator();
        while (courseIter.hasNext()) {
            Course course = courseIter.next();
            if (course.getCid() == cid) {
                isFound = true;
            }
        }
        if (!isFound) {
            this.courses.add(new Course(cid, title));
        }
    }

    /**
     * Prints a list of all the courses.
     */
    public void coursesList() {
        System.out.println(courses);
    }

    /**
     * If the given course is in this college, removes it and returns true.
     * Otherwise returns false.
     * 
     * @param cid
     *            the course to remove.
     * @return True if the course was removed, false if there is no such course.
     */
    public boolean removeCourse(int cid) {
        Course course = getCourse(cid);
        if (this.courses.remove(getCourse(cid))) {
            ListIterator<Student> studentsIter = this.students.iterator();
            while (studentsIter.hasNext()) {
                Student currentStudent = studentsIter.next();
                if(currentStudent.tookCourse(course))
                    currentStudent.removeCourse(course);
            }
            return true;
        } else {
            return false;
        }
    }

    // Returns the course that has the given id, or null if there is no such course.
    public Course getCourse(int cid) {
        ListIterator<Course> courseIter=this.courses.iterator();
        while (courseIter.hasNext()) {
            Course currentCourse=courseIter.next();
            if(currentCourse.getCid()==cid) {
                return currentCourse;
            }
        }
        return null;
    }

    /**
     * Adds the given student to the students list of this college.
     * 
     * @param sid
     *            student id
     * @param name
     *            student name
     */
    public void addStudent(int sid, String name) {
        boolean isFound = false;
        ListIterator<Student> studentIter = this.students.iterator();
        while (studentIter.hasNext()) {
            Student student = studentIter.next();
            if (student.getSid() == sid) {
                isFound = true;
            }
        }
        if (!isFound) {
            this.students.add(new Student(sid, name));
        }
    }

    /**
     * Prints a list of all the students.
     */
    public void studentsList() {
        System.out.println(students);
    }

    /**
     * If the given student is in this college, removes it and returns true.
     * Otherwise returns false.
     * 
     * @param sid
     *            the student's id.
     * @return True if the student was removed, false if there is no such student.
     */
    public boolean removeStudent(int sid) {
        return this.students.remove(getStudent(sid));
    }

    // Returns the student that has the given id, or null if there is no such
    // student.
    private Student getStudent(int sid) {
        ListIterator<Student> studentIter=this.students.iterator();
        while (studentIter.hasNext()) {
            Student currentStudent=studentIter.next();
            if(currentStudent.getSid()==sid) {
                return currentStudent;
            }
        }
        return null;
    }

    /**
     * Adds the given course to the course list of the given student.
     * 
     * @param sid
     *            student id
     * @param cid
     *            course id
     * @param grade
     *            student's grade in the course
     */
    public void addCourseTaken(int sid, int cid, int grade) {
        if (getStudent(sid) != null && getCourse(cid) != null) {
            getStudent(sid).addCourse(getCourse(cid), grade);
        }else {
            System.out.println("The student or course, is not exist!");
        }
    }

    /**
     * Prints the student report of the given student. See the Student class for
     * more details.
     * 
     * @param sid
     *            student id
     */
    public void studentReport(int sid) {
        if (getStudent(sid) != null) {
            if(getStudent(sid).getCourseTakenSize()!=0) {
                getStudent(sid).studentReport();
            }else {
                System.out.println("no courses taken yet");
            }
        }else {
            System.out.println("no such student");
        }
    }

    /**
     * Prints a list of all the students who took the course with the given cid.
     * 
     * @param cid
     *            the course
     */
    public void courseReport(int cid) {
        if (getCourse(cid) != null) {
            Course course = getCourse(cid);
            System.out.println("Course report: " + course.getTitle());
            LinkedList<Student> studentsInCourseList = studentsWhoTook(course);
            if (studentsInCourseList.size() == 0) {
                System.out.println("no student took this course");
            } else {
                ListIterator<Student> studentIter = studentsInCourseList.iterator();
                while (studentIter.hasNext()) {
                    Student currentStudent = studentIter.next();
                    System.out.println("Student " + currentStudent.getSid() + ": " + currentStudent.getName());
                }
            }
        }else {
            System.out.println("no such course");
        }
    }

    /**
     * Prints the number of students in the given course
     * 
     * @param cid
     *            course id
     */
    public void printSize(int cid) {
        if (getCourse(cid) != null) {
            int numberOfStudentsInCourse = 0;
            Course course = getCourse(cid);
            ListIterator<Student> studentIter = this.students.iterator();
            while (studentIter.hasNext()) {
                Student currentStudent = studentIter.next();
                if (currentStudent.tookCourse(course)) {
                    numberOfStudentsInCourse++;
                }
            }
            System.out.println(
                    "Course " + cid + ": " + course.getTitle() + " has " + numberOfStudentsInCourse + " students");
        }else {
            System.out.println("The course is not exist!");
        }
    }

    // Returns a list of all the students who took the given course
    private LinkedList<Student> studentsWhoTook(Course c) {
        LinkedList<Student> studentsInCourseList=new LinkedList<Student>();
        ListIterator<Student> studentIter=this.students.iterator();
        while (studentIter.hasNext()) {
            Student currentStudent=studentIter.next();
            if(currentStudent.tookCourse(c)) {
                studentsInCourseList.add(currentStudent);
            }
        }
        return studentsInCourseList;
    }

    /**
     * Prints the student with the highest grade in the given course.
     * 
     * @param cid
     *            course id
     */
    public void topPerfomerReport(int cid) {
        String NamesOfTopPerfomer = "";
        if (getCourse(cid) != null) {
            Course course = getCourse(cid);
            LinkedList<Student> studentsInCourseList = studentsWhoTook(course);
            ListIterator<Student> studentsInCourseIter = studentsInCourseList.iterator();
            if (studentsInCourseList.size() == 0) {
                System.out.println("no student took this course");
            } else {
                int gradetopPerfomerStudent = -1;
                while (studentsInCourseIter.hasNext()) {
                    Student currentStudent = studentsInCourseIter.next();
                    if (gradetopPerfomerStudent < currentStudent.gradeInCourse(course)) {
                        gradetopPerfomerStudent = currentStudent.gradeInCourse(course);
                        NamesOfTopPerfomer = currentStudent.getName();
                    } else {
                        if (gradetopPerfomerStudent == currentStudent.gradeInCourse(course)) {
                            NamesOfTopPerfomer +=", "+currentStudent.getName();
                        }
                    }
                }
                System.out.println("Top performer in Course " + cid + ": " + course.getTitle() + ": ");
                System.out.println(NamesOfTopPerfomer);
            }
        } else {
            System.out.println("The course is not exist!");
        }
    }

    /**
     * Returns the college name
     * 
     * @return the college name
     */
    public String getName() {
        return name;
    }

    /**
     * A textual representation of this college, along with its courses and
     * students.
     */
    public String toString() {
        String str = name + nl;
        str += "courses:" + nl;
        str += courses.toString() + nl;
        str += "students:" + nl;
        str += students.toString() + nl;
        return str;
    }
}

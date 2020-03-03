import java.util.ArrayList;

import java.util.HashMap;

import java.util.Scanner;

public class StudentScoresMenu {

private int position;

private final int maxsize;

private final HashMap<Integer, StudentInfo> students;

StudentScoresMenu(final int maxDataSize) {

    students = new HashMap<>();

    position = 1;

    this.maxsize = maxDataSize;

}

public static void main(final String[] args) {

    final Scanner sc = new Scanner(System.in);

    System.out.println("Enter max no of students: ");

    final int n = sc.nextInt();

    System.out.println("Enter initial no of students: ");

    final int initialStds = sc.nextInt();

    final StudentScoresMenu ctrl = new StudentScoresMenu(n);

    for (int i = 0; i < initialStds; i++) {

        final StudentInfo info = StudentScoresMenu.getStudentInfo(sc);

        ctrl.insert(info.getName(), info.getGrades());

    }

    System.out.println("Menu options:\n1 to insert a new student's information\n" +

            "2 to fetch and output a student's information\n" +

            "3 to delete a student's information\n" +

            "4 to update a student's information\n" +

            "5 to output all the student information\n" +

            "6 to exit the program");

    int option = 0;

    do {

        System.out.println("Enter option: ");

        option = sc.nextInt();

        if (option >= 1 && option <= 6) {

            if (option == 1) {

                final StudentInfo info = StudentScoresMenu.getStudentInfo(sc);

                ctrl.insert(info.getName(), info.getGrades());

            } else if (option == 2) {

                System.out.println("Enter student id: ");

                final int studentId = sc.nextInt();

                ctrl.print(ctrl.getStudentInfo(studentId));

            } else if (option == 3) {

                System.out.println("Enter student id to delete: ");

                final int studentId = sc.nextInt();

                ctrl.delete(studentId);

            } else if (option == 4) {

                System.out.println("Enter student id: ");

                final int studentId = sc.nextInt();

                final StudentInfo info = StudentScoresMenu.getStudentInfo(sc);

                ctrl.update(studentId, info.getName(), info.getGrades());

            } else if (option == 5) {

                ctrl.printAll();

            }

        }

    } while (option != 6);

}

public static StudentInfo getStudentInfo(final Scanner sc) {

    System.out.println("Enter student name: ");

    final String name = sc.next();

    System.out.println("Enter grades: (A-F) or Q to exit: ");

    String str = null;

    final ArrayList<String> grades = new ArrayList<>();

    do {

        str = sc.next();

        if (str.equals("Q"))

        {

            break;

        }

        else {

            grades.add(str);

        }

    } while (!str.equalsIgnoreCase("q"));

    final StudentInfo info = new StudentInfo(name, grades);

    return info;

}

public void insert(final String name, final ArrayList<String> grades) {

    if (position < maxsize) {

        final StudentInfo info = new StudentInfo(position++, name, grades);

        students.put(info.getId(), info);

        System.out.println("Student Info added. Id : " + info.getId());

    } else {

        System.out.println("Max data size reached");

    }

}

public void update(final int studentId, final String name, final ArrayList<String> grades) {

    if (students.containsKey(studentId)) {

        final StudentInfo info = getStudentInfo(studentId);

        if (name != null)

            info.setName(name);

        if (grades != null)

            info.setGrades(grades);

    } else {

        System.out.println("Student with id: " + studentId + " not exist");

    }

}

public void printAll() {

    if (position > 0) {

        for (int i = 0; i < position; i++)

            print(getStudentInfo(i));

    }

}

public void print(final StudentInfo info) {

    if (info != null) {

        System.out.println("Student ID: " + info.getId() + " Name: " + info.getName());

        System.out.println("Grades: ");

        final ArrayList<String> grades = info.getGrades();

        if (grades != null) {

            for (final String gr : grades) {

                System.out.print(gr + " ");

            }

            System.out.println();

        }

    }

}

public StudentInfo getStudentInfo(final int studentId) {

    if (students.containsKey(studentId))

        return students.get(studentId);

    return null;

}

public void delete(final int studentId) {

    if (students.containsKey(studentId))

    {

        System.out.println(studentId + " was removed");

        students.remove(studentId);

    }

}

}

class StudentInfo {

    private String name;

    private final int id;

    private ArrayList<String> grades;

    public StudentInfo(final String name, final ArrayList<String> grades) {

        this.name = name;

        this.id = -1;

        this.grades = grades;

    }

    public StudentInfo(final int id, final String name, final ArrayList<String> grades) {

        this.name = name;

        this.id = id;

        this.grades = grades;

    }

    public String getName() {

        return name;

    }

    public void setName(final String name) {

        this.name = name;

    }

    public ArrayList<String> getGrades() {

        return grades;

    }

    public void setGrades(final ArrayList<String> grades) {

this.grades = grades;

}

public int getId() {

return id;

}

}
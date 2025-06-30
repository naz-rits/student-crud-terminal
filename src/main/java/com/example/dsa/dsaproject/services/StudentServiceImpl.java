package com.example.dsa.dsaproject.services;

import com.example.dsa.dsaproject.model.Course;
import com.example.dsa.dsaproject.model.Student;
import com.example.dsa.dsaproject.repository.CourseRepository;
import com.example.dsa.dsaproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    Scanner sc = new Scanner(System.in);
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] words = str.split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return capitalized.toString().trim();
    }

    @Override
    @Transactional
    public void addStudent() {
        Student student = new Student();
        Course course = new Course();
        System.out.println("Input C or c, if you want to cancel");

        // first name
        while (student.getFirstName() == null) {
            System.out.print("Enter student's first name: ");
            try {
                String firstName = capitalize(sc.nextLine());
                if (firstName.isBlank()) {
                    System.out.println("Please enter a first name");
                }
                else if (!firstName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Error. Your input contains a number/special character");
                }
                else if (firstName.equals("c") || firstName.equals("C")) {
                    return;
                }
                else {
                    student.setFirstName(firstName);
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid first name");
            }
        }

        // last name
        while (student.getLastName() == null) {
            System.out.print("Enter student's last name: ");
            try {
                String lastName = capitalize(sc.nextLine());
                if (lastName.isBlank()) {
                    System.out.println("Please enter a last name");
                }
                else if (!lastName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Error. Your input contains a number/special character");
                }
                else if (lastName.equals("c") || lastName.equals("C")) {
                    return;
                }
                else {
                    student.setLastName(lastName);
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid last name");
            }
        }

        // middle name
        while (student.getMiddleName() == null) {
            System.out.print("Enter student's middle name (Please put N/A if you don't have a middle name): ");
            try {
                String middleName = sc.nextLine();
                if (middleName.equals("N/A")) {
                    student.setMiddleName("N/A");
                }
                else if (middleName.isBlank()) {
                    System.out.println("Please enter a middle name");
                }
                else if (!middleName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("Error. Your input contains a number/special character");
                }
                else if (middleName.equals("c") || middleName.equals("C")) {
                    return;
                }
                else {
                    student.setMiddleName(capitalize(middleName));
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid last name");
            }
        }


        // date of birth
        System.out.print("Enter student's birth date e.g. (yyyy-mm-dd): ");
        while (student.getDateOfBirth() == null) {
            try {
                String birthDate = sc.nextLine();
                if (birthDate.isBlank()) {
                    System.out.println("Please enter a birth date");
                }
                else if (birthDate.equals("c") || birthDate.equals("C")) {
                    return;
                }
                else {
                    LocalDate birth = LocalDate.parse(birthDate);
                    student.setDateOfBirth(birth);
                }
            } catch (DateTimeParseException e) {
                System.out.println("Enter a valid birth date e.g. (2005-08-16)");
            }
        }

        // age
        while (student.getAge() == null) {
            System.out.print("Enter the student's age: ");
            try {
                String age = sc.nextLine();
                if (age.isBlank()) {
                    System.out.println("Please enter a valid age");
                }
                else if (age.equals("c") || age.equals("C") ) {
                    return;
                }
                else if (Integer.parseInt(age) < 0) {
                    System.out.println("Please enter a valid age");
                }
                else {
                    student.setAge(Integer.parseInt(age));
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid age");
                sc.nextLine();
            }
        }

        // contact number

        while (student.getContactNumber() == null) {
            System.out.print("Enter student's contact number: ");
            try {
                String contactNumber = sc.nextLine();
                if (contactNumber.isBlank()) {
                    System.out.println("Please enter a contact number");
                }
                else if (contactNumber.equals("c") || contactNumber.equals("C")) {
                    return;
                }
                else if (!contactNumber.matches("^09\\d{9}$")) {
                    System.out.println("Invalid contact number format.");
                }
                else {
                    student.setContactNumber(contactNumber);
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid contact number");
            }
        }

        // address
        while (student.getAddress() == null) {
            System.out.print("Enter the student's address: ");
            try {
                String address = sc.nextLine();
                if (address.isBlank()) {
                    System.out.println("Please enter a valid address");
                }
                else if (address.equals("c") || address.equals("C")) {
                    return;
                }
                else {
                    student.setAddress(address);
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid address");
            }
        }

        // gender
        while (student.getGender() == null) {
            System.out.println("[1] Male");
            System.out.println("[2] Female");
            System.out.print("Enter the student's gender: ");
            try {
                String gender = sc.nextLine();
                if (Integer.parseInt(gender) == 1) {
                    student.setGender("Male");
                }
                else if (Integer.parseInt(gender) == 2) {
                    student.setGender("Female");
                }
                else if (gender.equals("c") || gender.equals("C")) {
                    return;
                }
                else {
                    System.out.println("Invalid gender");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid gender");
                sc.nextLine();
            }
        }

        // email
        while (student.getEmail() == null) {
            System.out.print("Enter the student's email address: ");
            try {
                String email = sc.nextLine();
                if (email.isBlank()) {
                    System.out.println("Please enter a valid email address");
                }
                else if (email.equals("c") || email.equals("C")) {
                    return;
                }
                else if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
                    System.out.println("A student with this email already exists.");
                    return;
                }

                else if (!email.matches("^[\\w.+-]+@gmail\\.com$")) {
                    System.out.println("Invalid email format.");
                }
                else {
                    student.setEmail(email);
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid email address");
            }
        }

        List<Course> courses = new ArrayList<>();
        System.out.print("Enter the number of courses/grades (or 'C' to cancel): ");
        try {
            String numberOfCoursesInput = sc.nextLine();
            if (numberOfCoursesInput.equalsIgnoreCase("c")) {
                return;
            }

            int numberOfCourses = Integer.parseInt(numberOfCoursesInput);

            if (numberOfCourses <= 0) {
                System.out.println("Please enter a positive number of courses.");
            }

            while (numberOfCourses > 0) {
                try {
                    System.out.print("Enter course code: ");
                    String courseCode = sc.nextLine();

                    if (courseCode.isBlank()) {
                        System.out.println("Please enter a valid course code.");
                        continue;
                    }

                    Course coursed = new Course();
                    coursed.setCourseName(courseCode);

                    System.out.print("Enter student's grade: ");
                    String gradeInput = sc.nextLine();

                    if (gradeInput.equalsIgnoreCase("c")) {
                        System.out.println("Cancelling add student. Returning to main menu...");
                        return;
                    }

                    int studentGrade = Integer.parseInt(gradeInput);

                    if (studentGrade < 0 || studentGrade > 100) {
                        System.out.println("Please enter a valid grade between 0 and 100.");
                        continue;
                    }

                    coursed.setCourseGrade(studentGrade);
                    coursed.setStudent(student);

                    courses.add(coursed);

                    numberOfCourses--;

                    System.out.println("Student grade has been added successfully.");
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid grade (number).");
                }
            }

            Student studentNumber = studentRepository.save(student);

            courseRepository.saveAll(courses); // Save all courses at once

            System.out.println("Student added successfully.");
            System.out.println();
            System.out.println();
            System.out.println("Your student number is: " + studentNumber.getStudentNumber());
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number of courses.");
        }

    }

    @Override
    @Transactional
    public void removeStudent() {
        System.out.println("Removing student section");
        System.out.print("Enter the student id (Input c to cancel): ");
        try {
            String studentId = sc.nextLine();
            if (studentId.isBlank()) {
                System.out.println("Please enter a valid student id");
            }
            else if (studentId.equals("c") || studentId.equals("C")) {
                return;
            }
            else {
                Optional<Student> studentOptional = studentRepository.findById(Long.parseLong(studentId));

                if (studentOptional.isPresent()) {
                    System.out.print("Input Y to proceed, N if cancel: ");
                    String answer = sc.nextLine().toUpperCase();
                    if (answer.equalsIgnoreCase("Y")) {
                        studentRepository.deleteById(Long.parseLong(studentId));

                        System.out.println("Student removed successfully.");
                    }
                    else if (answer.equalsIgnoreCase("N")) {
                        return;
                    }
                    else {
                        System.out.println("+-------------------------------------------------------+");
                        System.out.println("Invalid input");
                        System.out.println("+-------------------------------------------------------+");
                    }

                }
                else {
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("Student not found.");
                    System.out.println("+-------------------------------------------------------+");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("Enter a valid number of courses.");
            System.out.println("+-------------------------------------------------------+");
            sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("Enter a valid student number (number).");
            System.out.println("+-------------------------------------------------------+");
            sc.nextLine();
        }
    }

    @Override
    @Transactional
    public void updateStudent() {
        System.out.println("Updating student section");
        System.out.print("Enter the student id: ");

        try {
            Long studentId = sc.nextLong();
            Optional<Student> student = studentRepository.findById(studentId);


            if (student.isPresent()) {
                int choice = 0;
                while (choice != 10) {
                    Student theStudent = student.get();
                    System.out.println("+-------------------------------------------------------+");
                    System.out.println("Student number: " + theStudent.getStudentNumber());
                    System.out.println("[1] First name: " + theStudent.getFirstName());
                    System.out.println("[2] Last name: " + theStudent.getLastName());
                    System.out.println("[3] Middle name: " + theStudent.getMiddleName());
                    System.out.println("[4] Date of birth: " + theStudent.getDateOfBirth());
                    System.out.println("[5] Age: " + theStudent.getAge());
                    System.out.println("[6] Contact number: " + theStudent.getContactNumber());
                    System.out.println("[7] Address: " + theStudent.getAddress());
                    System.out.println("[8] Gender: " + theStudent.getGender());
                    System.out.println("[9] Email: " + theStudent.getEmail());
                    System.out.println("[10] Cancel");
                    System.out.println("+-------------------------------------------------------+");
                    System.out.print("Your choice is: ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter the student's new first name: ");
                            try {
                                String firstName = sc.nextLine();
                                if (firstName.isBlank()) {
                                    System.out.println("Please enter a first name");
                                }
                                else if (!firstName.matches("^[a-zA-Z ]+$")){
                                    System.out.println("Error. Your input contains a letter/special character");
                                }
                                else {
                                    theStudent.setFirstName(capitalize(firstName));
                                    System.out.println("Student first name updated successfully.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter a valid first name");
                            }
                            break;

                        case 2:
                            System.out.print("Enter the student's new last name: ");
                            try {
                                String lastName = sc.nextLine();
                                if (lastName.isBlank()) {
                                    System.out.println("Please enter a last name");
                                }
                                else if (!lastName.matches("^[a-zA-Z ]+$")){
                                    System.out.println("Error. Your input contains a number/special character");
                                }
                                else {
                                    theStudent.setLastName(capitalize(lastName));
                                    System.out.println("Student last name updated successfully.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter a valid last name");
                            }
                            break;

                        case 3:
                            System.out.print("Enter the student's new middle name: ");
                            try {
                                String middleName = sc.nextLine();
                                if (middleName.isBlank()) {
                                    System.out.println("Please enter a middle name");
                                }
                                else if (!middleName.matches("^[a-zA-Z ]+$")){
                                    System.out.println("Error. Your input contains a number/special character");
                                }
                                else {
                                    theStudent.setMiddleName(capitalize(middleName));
                                    System.out.println("Student middle name updated successfully.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter a valid middle name");
                            }
                            break;

                        case 4:
                            System.out.print("Enter the student's new date of birth (yyyy-MM-dd): ");
                            try {
                                LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
                                theStudent.setDateOfBirth(dateOfBirth);
                                System.out.println("Student date of birth updated successfully.");
                            } catch (DateTimeParseException e) {
                                System.out.println("Enter a valid date of birth");
                            }
                            break;

                        case 5:
                            System.out.println("Enter the student's new age: ");
                            try {
                                int age = sc.nextInt();
                                if (age <= 0) {
                                    System.out.println("Please enter a valid age");
                                }
                                else {
                                    theStudent.setAge(age);
                                    System.out.println("Student age updated successfully.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter a valid age");
                                sc.nextLine();
                            }
                            break;

                        case 6:
                            System.out.println("Enter the student's new contact number: ");
                            try {
                                String contactNumber = sc.nextLine();
                                if (contactNumber.isBlank()) {
                                    System.out.println("Please enter a valid contact number");
                                }
                                else if (!contactNumber.matches("^09\\d{9}$")) {
                                    System.out.println("Error. Please enter a valid contact number");
                                }
                                else {
                                    theStudent.setContactNumber(contactNumber);
                                    System.out.println("Student contact number updated successfully.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter a valid contact number");
                            }
                            break;

                        case 7:
                            System.out.println("Enter the student's new address: ");
                            try {
                                String address = sc.nextLine();
                                if (address.isBlank()) {
                                    System.out.println("Please enter a valid address");
                                }
                                else {
                                    theStudent.setAddress(address);
                                    System.out.println("Student address updated successfully.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter a valid address");
                            }
                            break;

                        case 8:

                            String currentGender = theStudent.getGender();

                            if (currentGender.equals("Male")) {
                                theStudent.setGender("Female");
                                System.out.println("Student gender updated successfully.");
                            }
                            else {
                                theStudent.setGender("Male");
                                System.out.println("Student gender updated successfully.");
                            }
                            break;

                        case 9:
                            System.out.println("Enter the student's new email address: ");
                            try {
                                String email = sc.nextLine();
                                if (email.isBlank()) {
                                    System.out.println("Please enter a valid email address");
                                }
                                else if (!email.matches("^[\\w.+-]+@gmail\\.com$")) {
                                    System.out.println("Error. Please enter a valid email address");
                                }
                                else {
                                    theStudent.setEmail(email);
                                    System.out.println("Student email address updated successfully.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Enter a valid email address");
                            }
                            break;

                        case 10:
                            System.out.println("Exiting...");
                            break;

                        default:
                            System.out.println("Enter a valid number");
                            break;

                    }
                }
            }
            else {
                System.out.println("Student with that student number does not exist.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
            sc.nextLine();
        }
    }

    @Override
    @Transactional
    public void updateStudentGrades() {
        System.out.print("Enter the student's student number: ");
        try {

            Long studentNumber = sc.nextLong();
            Optional<Student> optionalStudent = studentRepository.findById(studentNumber);

            if (optionalStudent.isPresent()) {
                List<Course> studentCourse = courseRepository.findByStudent_StudentNumber(studentNumber);
                System.out.println("[1] Add Grade to Student");
                System.out.println("[2] Remove Grade from Student");
                System.out.println("[3] Update Grade of Student");
                System.out.print("Your choice is: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // ADD course
                    case 1:
                        Course course = new Course();
                        Student student = optionalStudent.get();
                        System.out.print("Enter the course code: ");
                        try {
                            String courseCode = sc.nextLine();
                            System.out.print("Enter the grade: ");
                            try {
                                Integer grade = sc.nextInt();
                                course.setCourseName(courseCode);
                                course.setCourseGrade(grade);
                                course.setStudent(student);
                                studentCourse.add(course);
                                courseRepository.save(course);
                                System.out.println("New student grade added successfully.");

                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a valid grade");
                                sc.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a valid course code");
                        }
                        break;


                        // REMOVE course
                    case 2:
                        for (Course c : studentCourse) {
                            System.out.println("[" + c.getId() + "] " + c.getCourseName() + " : " + c.getCourseGrade());
                        }

                        System.out.print("Your choice is: ");
                        try {
                            Long choice2 = sc.nextLong();
                            Student student2 = optionalStudent.get();
                            List<Course> courses2 = student2.getCourses();
                            sc.nextLine();

                            // Find the course to remove
                            Course courseToRemove = null;
                            for (Course c : courses2) {
                                if (c.getId().equals(choice2)) {
                                    courseToRemove = c;
                                    break;
                                }
                            }

                            if (courseToRemove != null) {
                                courses2.remove(courseToRemove);
                                studentRepository.save(student2); // SAVE student → triggers orphan removal
                                System.out.println("Student grade removed successfully.");
                            } else {
                                System.out.println("Error. Can't remove — course not found in student.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a valid course code");
                            sc.nextLine();
                        }
                        break;

                        // UPDATE course
                    case 3:
                        try {
                            List<Course> studentsCourses = courseRepository.findByStudent_StudentNumber(studentNumber);
                            if (studentsCourses.isEmpty()) {
                                System.out.println("Student doesn't exist");
                            } else {
                                int i = studentsCourses.size() - (studentsCourses.size() - 1);
                                System.out.println("+-----------------------------------+");
                                for (Course course1 : studentsCourses) {
                                    System.out.printf("[%d] Course Code - " + course1.getCourseName() + " : " + course1.getCourseGrade() + "\n", course1.getId());
                                    i += 1;
                                }
                                System.out.println("+-----------------------------------+");
                                System.out.print("Enter your choice: ");
                                Long choice2 = sc.nextLong();
                                if (courseRepository.findById(choice2).isPresent()) {
                                    Course studentCoursed = courseRepository.findById(choice2).get();
                                    System.out.println("+-----------------------------------+");
                                    System.out.println("Student Name: " + optionalStudent.get().getFirstName() + " " + optionalStudent.get().getLastName());
                                    System.out.println(studentCoursed);
                                    System.out.println("+-----------------------------------+");
                                    System.out.println("[1] Update Course Code");
                                    System.out.println("[2] Update Course Grade");
                                    System.out.println("+-----------------------------------+");
                                    System.out.print("Your choice is: ");
                                    try {
                                        int choice3 = sc.nextInt();
                                        switch (choice3) {

                                            case 1:
                                                System.out.println("Enter the new course code: ");
                                                try {
                                                    String newCourseCode = sc.nextLine().toUpperCase();
                                                    if (!newCourseCode.isBlank()) {
                                                        studentCoursed.setCourseName(newCourseCode);
                                                        System.out.println("New course code updated successfully.");
                                                    }
                                                    else {
                                                        System.out.println("Please enter a valid course code");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Please enter a valid course code");
                                                }
                                                break;

                                            case 2:
                                                    try {
                                                        int newGrade = sc.nextInt();
                                                        if (newGrade > 0 && newGrade <= 100) {
                                                            studentCoursed.setCourseGrade(newGrade);
                                                            System.out.println("New course grade updated successfully.");
                                                        }
                                                        else {
                                                            System.out.println("Error. Please enter a valid course grade");
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("Please enter a valid course grade");
                                                        sc.nextLine();
                                                    }
                                                break;

                                           default:
                                                 System.out.println("Enter a valid course code");
                                                 sc.nextLine();
                                                 break;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Enter a valid course code");
                                        sc.nextLine();
                                    }
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a valid number");
                        }
                        break;

                    default:
                        System.out.println("Enter a valid number");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number");
            sc.nextLine();
        }
    }

    @Override
    public void getStudent() {
        System.out.println("Search student section");
        System.out.print("Enter the student id: ");

        try {
            Long studentId = sc.nextLong();
            sc.nextLine();
            Optional<Student> studentOptional = studentRepository.findById(studentId);
            List<Course> courseOptional = courseRepository.findByStudent_StudentNumber(studentId);

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                System.out.println("+-------------------------------------------------------+");
                System.out.println("Student number: " + student.getStudentNumber());
                System.out.println("First name: " + student.getFirstName());
                System.out.println("Last name: " + student.getLastName());
                System.out.println("Middle name: " + student.getMiddleName());
                System.out.println("Date of birth: " + student.getDateOfBirth());
                System.out.println("Age: " + student.getAge());
                System.out.println("Contact number: " + student.getContactNumber());
                System.out.println("Address: " + student.getAddress());
                System.out.println("Gender: " + student.getGender());
                System.out.println("Email: " + student.getEmail());
                System.out.println();
                System.out.println("Student Grades: ");
                for (Course course1 : courseOptional) {
                    System.out.println("Course Code - " + course1.getCourseName() + " : " + course1.getCourseGrade());
                    }
                }
            else {
                System.out.println("+-------------------------------------------------------+");
                System.out.println("Student doesn't exist");
            }
            System.out.println("+-------------------------------------------------------+");
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid student id");
            sc.nextLine();
        }
    }

}

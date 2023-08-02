// Module 26.9 intermediate project (Student/University method's comparator)
package org.example;


import org.example.models.Student;
import org.example.models.University;
import org.example.utils.XLSXFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainVeryOld {

    public static void main(String[] args) throws IOException {

//        Class XLSXFileReader() has private constructor & forbidden to create instance
//        System.out.println(new XLSXFileReader());

//        Class UnitedComparator() has private constructor & forbidden to create instance
//        System.out.println(new UnitedComparator());


        List<Student> studentDataStorage = new ArrayList<>(XLSXFileReader.getStudentData());
        List<University> universityDataStorage = new ArrayList<>(XLSXFileReader.getUniversityData());

        for (Student student: studentDataStorage) {
            System.out.println(student);
        }
        System.out.println();

        for (University university: universityDataStorage) {
            System.out.println(university);
        }
        System.out.println();

    }
}
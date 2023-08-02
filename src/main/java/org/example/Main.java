// Module 26.9 intermediate project (Student/University method's comparator)
package org.example;


import org.example.comparators.studentComparators.IStudentComparator;
import org.example.comparators.universityComparators.IUniversityComparator;
import org.example.enums.EStudentMethodComparator;
import org.example.enums.EUniversityMethodComparator;
import org.example.models.Student;
import org.example.models.University;
import org.example.utils.JsonUtils;
import org.example.utils.UnitedComparator;
import org.example.utils.XLSXFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.utils.JsonUtils.*;


public class Main {

    public static void main(String[] args) throws IOException {

//        Utility  Class XLSXFileReader() has private constructor & forbidden to create instance
//        System.out.println(new XLSXFileReader());

//        Utility Class UnitedComparator() has private constructor & forbidden to create instance
//        System.out.println(new UnitedComparator());

//        Utility Class JsonUtils() has private constructor & forbidden to create instance
//        System.out.println(new JsonUtils());


        List<Student> studentDataStorage = new ArrayList<>(XLSXFileReader.getStudentData());
        List<University> universityDataStorage = new ArrayList<>(XLSXFileReader.getUniversityData());

        String studentJson = studentToJson (studentDataStorage.get(0));
        System.out.println(studentJson);
        System.out.println();

        String studentListJson = studentListToJson (studentDataStorage);
        System.out.println(studentJson);
        System.out.println();


        String universityJson = universityToJson (universityDataStorage.get(5));
        System.out.println(universityJson);
        System.out.println();


    }
}
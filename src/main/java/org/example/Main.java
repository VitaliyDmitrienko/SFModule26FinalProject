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
import java.util.Objects;

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
//
//        Student studentSentToJson = studentDataStorage.get(0);
//        System.out.println("Student sent to Json: \n" + studentSentToJson);
//        System.out.println();
//        String studentReceivedFromJson = JsonUtils.studentToJson (studentSentToJson);
//        System.out.println("Student converted to Json-string: \n" + studentReceivedFromJson);
//        System.out.println();
//
//        Student studentRecoveredFromJson = JsonUtils.studentFromJson(studentReceivedFromJson);
//        System.out.println("Student received & recovered from Json: \n" + studentRecoveredFromJson);
//        System.out.println();
//        System.out.println("Students sent & received from Json are equals? This is: << "
//                + studentSentToJson.equals(studentRecoveredFromJson) + " >>.");
//        System.out.println();


        String studentListToJson = JsonUtils.studentListToJson (studentDataStorage);
        System.out.println(studentListToJson);
        System.out.println();

        List<Student> studentListFromJson = JsonUtils.studentListFromJson(studentListToJson);
        System.out.println(studentListFromJson);
        System.out.println("studentDataStorage size is: " + studentDataStorage.size());
        System.out.println("studentListFromJson size is: " + studentListFromJson.size());
        System.out.println();

//        University universitySentToJson = universityDataStorage.get(5);
//        System.out.println("University sent to Json: \n" + universitySentToJson);
//        System.out.println();
//        String universityReceivedJson = JsonUtils.universityToJson (universitySentToJson);
//        System.out.println("University converted to Json-string: \n" + universityReceivedJson);
//        System.out.println();
//
//        University universityRecoveredFromJson = JsonUtils.universityFromJson(universityReceivedJson);
//        System.out.println("University received & recovered from Json: \n" + universityRecoveredFromJson);
//        System.out.println();
//        System.out.println("University sent & received from Json are equals? This is: <<"
//                + studentSentToJson.equals(studentRecoveredFromJson) + ">>.");





    }
}
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
import java.util.function.Function;
import java.util.stream.Stream;

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

        Student studentSentToJson = studentDataStorage.get(0);
        System.out.println("Student (single/original) sent to Json: \n" + studentSentToJson);
        String studentReceivedFromJson = JsonUtils.studentToJson (studentSentToJson);
        System.out.println("Student (single) converted to Json-string: \n" + studentReceivedFromJson);
        System.out.println();

        Student studentRecoveredFromJson = JsonUtils.studentFromJson(studentReceivedFromJson);
        System.out.println("Student (single) received & recovered from Json: \n" + studentRecoveredFromJson);
        System.out.println();
        System.out.println("Students (single) sent to & received from Json are equals? This is: << "
                + studentSentToJson.equals(studentRecoveredFromJson) + " >>.");
        System.out.println("<===================================================>");
        System.out.println();

        String studentListToJson = JsonUtils.studentListToJson (studentDataStorage);
        System.out.println("Full Student's List converted to Json format: ");
        System.out.println("Total List size is: " + studentDataStorage.size() + " .");
        System.out.println("Head of Full List Json-string. ");
        System.out.println(studentListToJson);
        System.out.println("End of Full List Json-string. ");
        System.out.println("<===================================================>");
        System.out.println();

        List<Student> studentListFromJson = JsonUtils.studentListFromJson(studentListToJson);
        System.out.println("Full Students List received & recovered from Json format to original: ");
        System.out.println("Total List size is: " + studentListFromJson.size() + " .");
        System.out.println(studentListFromJson);
        System.out.println("studentDataStorage size is: " + studentDataStorage.size());
        System.out.println("studentListFromJson size is: " + studentListFromJson.size());
        System.out.println();
        System.out.println("Student's Lists size (sent & received) from Json are equals? This is: << "
                + (studentDataStorage.size() == studentListFromJson.size()) + " >>.");
        System.out.println("<===================================================>");
        System.out.println();

//        Моё собственное решение: был в одном шаге от завершения, но запутался в неоднозначной формулировке автора ТЗ
//        studentDataStorage.stream().peek(s -> {
//            Function<Student, String> studentToJson = JsonUtils::studentToJson;
//            System.out.println("Student converted to Json: " + studentToJson);
//        }).forEach(s -> System.out.println("Student: " + s));
//       studentDataStorage.stream().peek(s -> {
//            String studentToJson = JsonUtils.studentToJson(s);
//            System.out.println("Student converted to Json: " + studentToJson);
//       }).forEach(s -> System.out.println("Student: " + s));

//        Авторское решение ментора Максима Шишова:
//        Stream<University> listOfUniversity1 = universityBeforeSerialization.stream();
//        Stream<University> listOfUniversity2 = universityBeforeSerialization.stream();
//        Stream.concat(
//                        listOfUniversity1.limit(2).map(JsonUtil::serializeUniversityObject),
//                        listOfUniversity2.limit(2).map(JsonUtil::serializeUniversityObject).map(JsonUtil::deserializeUniversityObject))
//                .forEach(System.out::println);
//        допилено мной под мой проект:
        System.out.println("Students List In/Out from Json one after the other at the same time by double/concat to single Stream: \n");
        Stream<Student> listOfUniversity1 = studentDataStorage.stream();
        Stream<Student> listOfUniversity2 = studentDataStorage.stream();
        Stream.concat(
                        listOfUniversity1.limit(12).map(JsonUtils::studentToJson),
                        listOfUniversity2.limit(12).map(JsonUtils::studentToJson).
                                map(JsonUtils::studentFromJson))
                .forEach(System.out::println);
        System.out.println("<===================================================>");
        System.out.println();


//        Авторское решение составителя ТЗ с платформы:
//        Сериализация/десериализация одновременно в одном потоке при помощи итератора
//        проверено: работает как надо
//        System.out.println("Students List In/Out from Json parallel at the same time by single Stream: \n");
//        studentDataStorage.forEach(student -> {
//            String studentJson = JsonUtils.studentToJson(student);
//            System.out.println("Serialized student to Json: " + studentJson);
//            Student studentFromJson = JsonUtils.studentFromJson(studentJson);
//            System.out.println("Restored student from Json: \n" + studentFromJson);
//        });
//        System.out.println();


        System.out.println("<===================================================>");
        University universitySentToJson = universityDataStorage.get(5);
        System.out.println("University (original/single) sent to Json: \n" + universitySentToJson);
        System.out.println();
        String universityReceivedJson = JsonUtils.universityToJson (universitySentToJson);
        System.out.println("University (single) converted to Json-string: \n" + universityReceivedJson);
        System.out.println();

        University universityRecoveredFromJson = JsonUtils.universityFromJson(universityReceivedJson);
        System.out.println("University received & recovered from Json: \n" + universityRecoveredFromJson);
        System.out.println();
        System.out.println("University sent to & received from Json are equals? This is: <<"
                + studentSentToJson.equals(studentRecoveredFromJson) + ">>.");

        System.out.println("<===================================================>");
        String universityListToJson = JsonUtils.universityListToJson (universityDataStorage);
        System.out.println("Full Universities List converted to Json format: ");
        System.out.println("Total List size is: " + universityDataStorage.size() + " .");
        System.out.println("Head of Full List Json-string. ");
        System.out.println(universityListToJson);
        System.out.println("End of Full List Json-string. ");
        System.out.println("<===================================================>");
        System.out.println();

        List<University> universityListFromJson = JsonUtils.universityListFromJson(universityListToJson);
        System.out.println("Full University's List received & recovered from Json format to original: ");
        System.out.println("Total List size is: " + universityListFromJson.size() + " .");
        System.out.println(universityListFromJson);
        System.out.println("universityDataStorage size is: " + universityDataStorage.size());
        System.out.println("universityListFromJson size is: " + universityListFromJson.size());
        System.out.println();
        System.out.println("Universities Lists size (sent & received) from Json are equals? This is: << "
                + (universityDataStorage.size() == universityListFromJson.size()) + " >>.");
        System.out.println("<===================================================>");
        System.out.println();

//        Авторское решение составителя ТЗ с платформы:
//        Сериализация/десериализация одновременно в одном потоке при помощи итератора
//        проверено: работает как надо
        System.out.println("Universities List In/Out from Json parallel at the same time by single Stream: \n");
        universityDataStorage.forEach(university -> {
            String universityJson = JsonUtils.universityToJson(university);
            System.out.println("Serialized university to Json: " + universityJson);
            University universityFromJson = JsonUtils.universityFromJson(universityJson);
            System.out.println("Restored university from Json: \n" + universityFromJson);
        });
        System.out.println("<===================================================>");

    }
}
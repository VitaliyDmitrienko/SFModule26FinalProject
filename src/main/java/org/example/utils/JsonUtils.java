package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.models.Student;
import org.example.models.University;

import java.util.List;

public final class JsonUtils {

    private JsonUtils() {
        System.out.println("Private constructor.");
        System.out.println("Forbidden to create this class instance.");
    }

    public static String studentToJson (Student student) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(student);
        return jsonString;

    }

    public static String studentListToJson (List<Student> studentDataStorage){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(studentDataStorage);
        return jsonString;

    }
    public static String universityToJson (University university) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(university);
        return jsonString;

    }

}

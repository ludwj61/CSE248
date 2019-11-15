package com.example.collegeapplicationsystem.JSONParsing;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
    public static void saveColleges(ArrayList<College> colleges, String fileName) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(colleges);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<College> loadColleges(String fileName) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            return (List<College>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<College> loadColleges(String fileName, Context context) {
        InputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = context.getAssets().open(fileName);
            ois = new ObjectInputStream(fis);
            return (List<College>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

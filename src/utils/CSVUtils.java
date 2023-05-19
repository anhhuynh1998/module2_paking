package utils;

import views.PackingView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    public static <T> void write(String path, List<T> items) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            for (T item : items) {
                printWriter.println(item.toString());
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
    }

    public static void writeFile(String path, List<String> lines) {
        try (FileWriter writer = new FileWriter(path, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty())
                lines.add(line);
        } catch (IOException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
        return lines;
    }

    public static List<String> readLichSu(String lichsu) {
        List<String> linesss = new ArrayList<>();
        try {
            File file = new File(lichsu);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String liness;
            while ((liness = br.readLine()) != null && !liness.trim().isEmpty())
                linesss.add(liness);
        } catch (IOException e) {
            throw new IllegalArgumentException(lichsu + " invalid");
        }
        return linesss;
    }
    public static List<String> readUser(String user) {
        List<String> linesss = new ArrayList<>();
        try {
            File file = new File(user);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String liness;
            while ((liness = br.readLine()) != null && !liness.trim().isEmpty())
                linesss.add(liness);
        } catch (IOException e) {
            throw new IllegalArgumentException(user + " invalid");
        }
        return linesss;
    }
    public static void writeUser(String user, List<String> lines) {
        try (FileWriter writer = new FileWriter(user, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

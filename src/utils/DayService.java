package utils;

import views.DoanhThu;
import views.PackingView;

import java.util.List;
import java.util.Scanner;

public class DayService {
    private final static String lichSu = "D:\\Module_2\\casestudy_parking\\data\\lichsu.csv";
    static Scanner scanner = new Scanner(System.in);
    public static int enterDay() {
        List<String> newShowParkings = CSVUtils.readLichSu(lichSu);
        DoanhThu.showLichSU(newShowParkings);
        System.out.println("Nhập ngày (1-31): ");
        String dayStr = scanner.nextLine();

        try {
            int day = Integer.parseInt(dayStr);
            if (day >= 1 && day <= 31) {
                return day;
            } else {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại!");
                return enterDay();
            }
        } catch (NumberFormatException e) {
            System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại!");
            return enterDay();
        }
    }
}

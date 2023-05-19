package utils;

import views.PackingView;

import java.util.List;
import java.util.Scanner;

public class MonthService {
    private final static String lichSu = "D:\\Module_2\\casestudy_parking\\data\\lichsu.csv";
    static Scanner scanner = new Scanner(System.in);
    public static int enterMonth() {
        List<String> newShowParkings = CSVUtils.readLichSu(lichSu);
        PackingView.showLichSU(newShowParkings);
        do {
            System.out.println("Nhập tháng(1-12) : ");
            String valueMonth = scanner.nextLine();
            try {
                int month = Integer.parseInt(valueMonth);
                if (month >= 1 && month <= 12) {
                    return month;
                } else {
                    System.out.println("tháng không hợp lệ nhập lại (ví dụ : 1) :");
                    return enterMonth();
                }
            } catch (NumberFormatException e) {
                System.out.println("Định dạng tháng không hợp lệ");
                return enterMonth();
            }
        } while (true);
    }
}

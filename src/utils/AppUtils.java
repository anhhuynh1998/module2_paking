package utils;

import views.PackingView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AppUtils {
    private final static String lichSu = "D:\\Module_2\\casestudy_parking\\data\\lichsu.csv";
    static Scanner scanner = new Scanner(System.in);

    public static String doubleToVND(double value) {
        String patternVND = ",###₫";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static void exit() {
        System.out.println("\tTạm biệt. Hẹn gặp lại!");
        System.exit(7);
    }

    public static String nhapBienSo() {
        System.out.println("Nhập biển số: ");
        String bienSo = scanner.nextLine();
        final String mauBienSo = "[A-Z]{2}\\d{5}";
        if (Pattern.compile(mauBienSo).matcher(bienSo).matches()) {
            return bienSo;
        } else {
            System.out.println("nhập lại đúng định dạng biển số");
            return nhapBienSo();
        }
    }

    public static int retryChoose() {
        int option;
        int min =0;
        int max =6;
        do {
            try {
                System.out.print("⭆");
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Bạn nhập sai chức năng vui lòng nhập lai");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("Bạn nhập sai chức năng vui lòng nhập lại");
            }
        } while (true);
        return option;
    }
}

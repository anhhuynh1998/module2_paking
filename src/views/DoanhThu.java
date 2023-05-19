package views;

import utils.AppUtils;
import utils.CSVUtils;
import utils.DayService;
import utils.MonthService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class DoanhThu {
    private static Scanner scanner = new Scanner(System.in);
    private static String lichSu = "D:\\Module_2\\casestudy_parking\\data\\lichsu.csv";

    public static void tinhDoanhThu() {
        System.out.println("1. Tính doanh thu tháng");
        System.out.println("2. Tính doanh thu ngày");
        System.out.println("Chọn loại doanh thu (1-2):");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                tinhDoanhThuThang();
                break;
            case 2:
                tinhDoanhThuNgay();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    private static void tinhDoanhThuThang() {
        int thang = MonthService.enterMonth();

        int tongTien = 0;
        List<String> xuatRaLines = CSVUtils.read(lichSu);

        for (String line : xuatRaLines) {
            String[] split = line.split(",");
            long id = Long.parseLong(split[0]);
            String name = split[1];
            String bienSo = split[2];
            double gia = Double.parseDouble(split[3]);
            LocalDate ngayGui = LocalDate.parse(split[4]);

            if (ngayGui.getMonthValue() == thang) {
                tongTien += gia;
            }
        }

        System.out.println("Doanh thu tháng " + thang + " là: " + tongTien + " đồng.");
        Fragment.checkContinue();
    }

    private static void tinhDoanhThuNgay() {
        int ngay = DayService.enterDay();

        int tongTien = 0;
        List<String> xuatRaLines = CSVUtils.read(lichSu);

        for (String line : xuatRaLines) {
            String[] split = line.split(",");
            long id = Long.parseLong(split[0]);
            String name = split[1];
            String bienSo = split[2];
            double gia = Double.parseDouble(split[3]);
            LocalDate ngayGui = LocalDate.parse(split[4]);

            if (ngayGui.getDayOfMonth() == ngay) {
                tongTien += gia;
            }
        }

        System.out.println("Doanh thu ngày " + ngay + " là: " + tongTien + " đồng.");
        Fragment.checkContinue();
    }
}

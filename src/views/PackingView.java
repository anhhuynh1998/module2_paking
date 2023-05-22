package views;

import model.Ticket;
import service.ParkingService;
import utils.AppUtils;
import utils.CSVUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static utils.AppUtils.exit;

public class PackingView {

    static Scanner scanner = new Scanner(System.in);
    static ParkingService parkingService = new ParkingService();

    public static void showParking() {
        int choice;
        while (true) {
            Parking();
            choice = AppUtils.retryChoose();
            switch (choice) {
                case 1:
                    AddCar.addCars();
                    break;
                case 2:
                    EditCar.suaThongTinXe();
                    break;
                case 3:
                    OutCar.layXeRa();
                    break;
                case 4:
                    List<String> showCars = null;
                    showTicket(showCars);
                    Fragment.checkContinue();
                    break;
                case 5:
                    DoanhThu.tinhDoanhThu();
                    break;
                case 6:
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời bạn chọn lại!");
                    break;
            }

        }
    }


    public static LocalDate inputNgayGui() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Ngày Gửi :" + localDate);
        return localDate;
    }

    public static String editName() {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        final String nameRegex = "[a-zA-Z ]+";
        if (Pattern.compile(nameRegex).matcher(name).matches()) {
            return name;
        } else {
            System.out.println("nhập lại đúng định dạng tên");
            return editName();
        }
    }

    public static void inVeXe(Ticket ticket) {
        System.out.println("---------- VÉ XE ----------");
        System.out.println("Biển số xe: " + ticket.getBienSo());
        System.out.println("Tên xe: " + ticket.getName());
        System.out.println("Ngày gửi: " + ticket.getNgayGui());
        System.out.println("ID vé: " + ticket.getId());
        System.out.println("Giá vé: " + ticket.getGia());
        System.out.println("----------------------------");
    }






    public static void showTicket(List<String> showCars) {
        System.out.println("-----------------------------------------Thông Tin Xe Trong Bãi-------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Id", "Tên Xe", "Biển Số ", "Giá", "Ngày Gửi");
        for (Ticket ticket : parkingService.findAll()) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s\n",
                    ticket.getId(),
                    ticket.getName(),
                    ticket.getBienSo(),
                    AppUtils.doubleToVND(ticket.getGia())
                    , ticket.getNgayGui());
        }
    }



    public static void Parking() {
        System.out.println(
                "\n|     ====== Quan ly bai do xe ======     |" +
                        "\n|1. Thêm Xe Vào Bãi                       |" +
                        "\n|2. Sửa Thông tin XE                      |" +
                        "\n|3. Lấy xe ra khỏi bãi                    |" +
                        "\n|4. Xem danh sách xe trong bãi            |" +
                        "\n|5. Doanh thu                       |" +
                        "\n|6. Thoát                                 |" +
                        "\nMời bạn Chọn :                         ");
    }
}

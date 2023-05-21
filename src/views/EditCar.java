package views;

import model.Ticket;
import service.ParkingService;
import utils.AppUtils;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditCar {
    private final static String path = "D:\\Module_2\\casestudy_parking\\data\\information.csv";

    static Scanner scanner = new Scanner(System.in);
    static ParkingService parkingService = new ParkingService();
    public static void suaThongTinXe() {
        List<Ticket> cars = parkingService.findAll();
        List<String> lines = new ArrayList<>();

        List<String> showCars = CSVUtils.read(path);
        PackingView.showTicket(showCars);
        String bienSo;
        System.out.println("Nhập biển số cần sửa: ");
        bienSo = scanner.nextLine();
        Ticket xeCanSua = null;
        for (Ticket car : cars) {
            if (car.getBienSo().equals(bienSo)) {
                xeCanSua = car;
                String newBienSo = AppUtils.nhapBienSo();
                car.setBienSo(newBienSo);
                System.out.println("Nhập lại tên: ");
                String newName = scanner.nextLine();
                car.setName(newName);
                break;
            }
        }
        if (xeCanSua == null) {
            System.out.println("Không tìm thấy xe!");
            return;
        }
        for (Ticket car : cars) {
            String line = car.getId() + "," + car.getName() + "," + car.getBienSo() + "," + car.getGia() + "," + car.getNgayGui();
            lines.add(line);
        }

        // Ghi lại thông tin xe vào file CSV
        CSVUtils.write(path, lines);
        System.out.println("Sửa thông tin xe thành công!");
        Fragment.checkContinue();
    }
}

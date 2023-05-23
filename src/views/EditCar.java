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
                String newName = PackingView.editName();
                car.setName(newName);

                if (confirmEditCar()) {
                    for (Ticket updatedCar : cars) {
                        String line = updatedCar.getId() + "," + updatedCar.getName() + "," + updatedCar.getBienSo() + "," + updatedCar.getGia() + "," + updatedCar.getNgayGui();
                        lines.add(line);
                    }
                    CSVUtils.write(path, lines);
                    System.out.println("Sửa thông tin xe thành công!");
                } else {
                    System.out.println("Không sửa thông tin");
                }

                break;
            }
        }

        if (xeCanSua == null) {
            System.out.println("Không tìm thấy xe!");
            suaThongTinXe();
            return;
        }

        Fragment.checkContinue();
    }

    public static boolean confirmEditCar() {
        System.out.println("Bạn có muốn sửa thông tin này không? (y/n)");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("y");
    }
}

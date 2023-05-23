package views;

import model.Ticket;
import service.ParkingService;
import utils.AppUtils;

import java.util.Scanner;

public class AddCar {
    private final static String path = "D:\\Module_2\\casestudy_parking\\data\\information.csv";
    private final static String lichSu = "D:\\Module_2\\casestudy_parking\\data\\lichsu.csv";

    static Scanner scanner = new Scanner(System.in);
    static ParkingService parkingService = new ParkingService();
    public static void addCars() {
        String name = PackingView.editName();
        String bienSo = AppUtils.nhapBienSo();
        Ticket newTicket = new Ticket()
                .setId(System.currentTimeMillis())
                .setName(name)
                .setBienSo(bienSo)
                .setGia()
                .setNgayGui(PackingView.inputNgayGui());

        System.out.println("Chuẩn bị thêm vào bãi...");

        if (confirmAddCar()) {
            parkingService.add(newTicket);
            System.out.println("Thêm vào bãi thành công");
            PackingView.inVeXe(newTicket);
        } else {
            System.out.println("Không thêm vào bãi");
        }

        Fragment.checkContinue();
    }
    public static boolean confirmAddCar() {
        System.out.println("Bạn có muốn thêm vào không? (y/n)");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("y");
    }

}

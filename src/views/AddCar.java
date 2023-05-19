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
        String name = PackingView.inputName();
        String bienSo = AppUtils.nhapBienSo();
        Ticket newTicket = new Ticket()
                .setId(System.currentTimeMillis())
                .setName(name)
                .setBienSo(bienSo)
                .setGia()
                .setNgayGui(PackingView.inputNgayGui());
        parkingService.add(newTicket);
        System.out.println("thêm vào bãi thành công");
        PackingView.inVeXe(newTicket);
        Fragment.checkContinue();
    }
}

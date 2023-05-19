package views;

import model.Ticket;
import service.ParkingService;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OutCar {
    private final static String path = "D:\\Module_2\\casestudy_parking\\data\\information.csv";
    private final static String lichSu = "D:\\Module_2\\casestudy_parking\\data\\lichsu.csv";

    static Scanner scanner = new Scanner(System.in);
    static ParkingService parkingService = new ParkingService();
    public static void layXeRa() {
        List<Ticket> outParking = parkingService.findAll();
        List<String> newLines = new ArrayList<>();
        List<String> newShowParking = CSVUtils.read(path);
        PackingView.showTicket(newShowParking);
        System.out.println("Nhập biển số: ");
        String bienSo = scanner.nextLine();
        Ticket xeCanTim = null;
        for (Ticket moto : outParking) {
            if (moto.getBienSo().equals(bienSo)) {
                xeCanTim = moto;
                break;
            }
        }
        if (xeCanTim == null) {
            System.out.println("Không tìm thấy xe!");
            return;
        }

        // Xóa xe ra khỏi danh sách
        outParking.remove(xeCanTim);

        // Cập nhật thông tin xe trong danh sách newLines
        for (Ticket moto : outParking) {
            String line = moto.getId() + "," + moto.getName() + "," + moto.getBienSo() + "," + moto.getGia() + "," + moto.getNgayGui();
            newLines.add(line);
        }

        // Ghi lại thông tin xe vào file CSV
        CSVUtils.write(path, newLines);
        String lichSuPath = lichSu;
        List<String> lichSuLines = new ArrayList<>();
        lichSuLines.add(xeCanTim.getId() + "," + xeCanTim.getName() + "," + xeCanTim.getBienSo() + "," + xeCanTim.getGia() + "," + xeCanTim.getNgayGui());
        CSVUtils.writeFile(lichSuPath, lichSuLines);

        System.out.println("Xe đã được lấy ra khỏi bãi đỗ xe.");

        System.out.println("\n==============================" +
                "\n=Chúc bạn 1 ngày tốt lành    =" +
                "\n=                            =" +
                "\n============================");
        Fragment.checkContinue();
    }
}

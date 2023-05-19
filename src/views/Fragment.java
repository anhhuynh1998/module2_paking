package views;

import static views.PackingView.scanner;

public class Fragment {
    public static void checkContinue() {
        System.out.println("Bạn có muốn tiếp tục không? (y/n)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("y")) {
            PackingView.showParking();
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("Chúc bạn 1 ngày tốt lành !");
            System.exit(0);
        } else {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 'y, 'n'.");
            checkContinue();
        }
    }
}

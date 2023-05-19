package views;

import service.UserService;

import java.util.Scanner;

public class UserView {
    static Scanner scanner = new Scanner(System.in);
    public static boolean userView1(){
        System.out.println("Vui Lòng đăng nhập để sử dụng hệ thống");
        while (true){
            System.out.println("Nhập UserName :");
            String userName = scanner.nextLine();
            System.out.println("Nhập PassWord :");
            String passWord = scanner.nextLine();

            boolean isUser = UserService.checkUser(userName,passWord);
            if(isUser){
                return  true;
            } else {
                System.out.println("tài khoản hoặc mật khẩu không chính xác");
            }
        }
    }
}

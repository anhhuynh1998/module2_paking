package service;

import utils.CSVUtils;

import java.util.List;

public class UserService {
    private final static String user = "D:\\Module_2\\casestudy_parking\\data\\user.csv";

    public static boolean checkUser(String userInput, String passWordIp){
        List<String> users = CSVUtils.read(user);
        for (String str: users) {
            String[] strings = str.split(",");
            String userName = strings[1];
            String passWord = strings[2];
            if (userInput.equals(userName)&& passWordIp.equals(passWord)){
                return true;
            }
        }
        return false;
    }

}

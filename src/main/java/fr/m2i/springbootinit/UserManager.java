package fr.m2i.springbootinit;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static List<String> userList = new ArrayList<>();

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

}

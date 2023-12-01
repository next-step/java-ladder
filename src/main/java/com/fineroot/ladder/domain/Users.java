package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> userList;

    private Users(List<User> userList) {
        this.userList = userList;
    }

    private static void validateDuplicate(List<User> list, User user) {
        if(list.contains(user)){
            throw new IllegalArgumentException(ExceptionMessage.USER_NAME_DUPLICATED.getMessage());
        }
    }

    public static Users fromString(String users) {
        List<User> resultList = new ArrayList<>();
        List<String> userStringList = Arrays.stream(users.split(",")).map(String::trim).collect(Collectors.toList());
        for (String s : userStringList) {
            User user = User.from(s);
            validateDuplicate(resultList, user);
            resultList.add(user);
        }
        return new Users(resultList);
    }

    public int size() {
        return userList.size();
    }

    public int firstUsernameLength(){
        return userList.get(0).length();
    }

    @Override
    public String toString() {
        return userList.stream().map(e->" ".repeat(5-e.toString().length()).concat(e.toString()).concat(" ")).collect(
                Collectors.joining()).stripTrailing();
    }
}

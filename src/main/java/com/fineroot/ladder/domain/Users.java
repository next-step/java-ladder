package com.fineroot.ladder.domain;

import static com.fineroot.ladder.utils.ExceptionMessage.USERS_CALL_LONGEST_LENGTH;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> userList;

    private Users(String userList) {
        List<User> list = new ArrayList<>();
        List<String> collect = Arrays.stream(userList.split(",")).map(String::trim).collect(Collectors.toList());
        for (String s : collect) {
            User user = User.from(s);
            validateDuplicate(list, user);
            list.add(user);
        }
        this.userList = list;
    }

    private void validateDuplicate(List<User> list, User user) {
        if(list.contains(user)){
            throw new IllegalArgumentException(ExceptionMessage.USER_NAME_DUPLICATED.getMessage());
        }
    }

    public static Users fromString(String users) {
        return new Users(users);
    }

    public int size() {
        return userList.size();
    }

    public int longestUserNameLength() {
        return userList.stream().sorted(Comparator.reverseOrder()).limit(1)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(USERS_CALL_LONGEST_LENGTH.getMessage()))
                .length();
    }

    public int firstUsernameLength(){
        return userList.get(0).length();
    }

    @Override
    public String toString() {
        int longestUserNameLength = longestUserNameLength();
        return userList.stream().map(e->" ".repeat(longestUserNameLength-e.toString().length()).concat(e.toString()).concat(" ")).collect(
                Collectors.joining()).stripTrailing();
    }
}

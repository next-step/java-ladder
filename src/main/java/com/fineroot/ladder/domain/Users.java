package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {

    private final Set<User> userSet;

    private Users(String users) {
        Set<User> set = new HashSet<>();
        List<String> collect = Arrays.stream(users.split(",")).map(String::trim).collect(Collectors.toList());
        for (String s : collect) {
            validateDuplicate(s, set);
        }
        userSet = set;
    }

    private void validateDuplicate(String s, Set<User> set) {
        if(!set.add(User.from(s))){
            throw new IllegalArgumentException(ExceptionMessage.USER_NAME_DUPLICATED.getMessage());
        }
    }

    public static Users fromString(String users) {
        return new Users(users);
    }

    public int size() {
        return userSet.size();
    }

}

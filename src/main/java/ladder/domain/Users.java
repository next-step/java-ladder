package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users
{
    private final List<User> list;

    private Users(List<User> list) {
        this.list = list;
    }

    public static Users from(String[] names) {
        valid(names);
        return new Users(Arrays.stream(names)
            .map(User::from)
            .collect(Collectors.toList()));
    }

    public int getUserCount() {
        return list.size();
    }

    public List<User> getUserList() {
        return list;
    }

    private static void valid(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("참여 인원 최소 2명이상 입니다.");
        }
    }
}

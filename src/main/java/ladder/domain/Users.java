package ladder.domain;

import ladder.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(String names) {
        validEmpty(names);
        validNameCheck(names);
        users = makeUsersList(names);
    }

    private void validEmpty(String names) {
        if (StringUtils.validEmpty(names)) {
            throw new IllegalArgumentException("이름을 입력하셔야 합니다.");
        }
    }

    private void validNameCheck(String names) {
        if (getNameCount(names) != getNameDistinctCount(names)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private List<User> makeUsersList(String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .map(User::new)
                .collect(Collectors.toList());
    }

    private int getNameCount(String names) {
        return (int) Arrays.stream(names.split(","))
                .map(String::trim)
                .count();
    }

    private int getNameDistinctCount(String names) {
        return (int) Arrays.stream(names.split(","))
                .map(String::trim)
                .distinct()
                .count();
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return (int) users.stream()
                .map(User::getName)
                .count();
    }
}

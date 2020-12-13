package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {

    private static final String COMMA = ",";
    private static final int ZERO = 0;

    private final List<User> userList;

    private Users(List<User> userList) {
        this.userList = userList;
    }

    public static Users initUsers(String names) {
        validateSplit(names);
        String[] split = names.split(COMMA);

        List<User> userList = new ArrayList<>(split.length);

        int index = ZERO;
        for(String name : split) {
            userList.add(User.of(index++, name));
        }

        return new Users(userList);
    }

    public static Users from(List<User> userList) {
        return new Users(userList);
    }

    private static void validateSplit(String names) {
        if(!names.contains(",")) {
            throw new IllegalArgumentException("2명 이상의 참가자가 있어야 합니다.");
        }
    }

    public int getUserNumbers() {
        return userList.size();
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList);
    }
}

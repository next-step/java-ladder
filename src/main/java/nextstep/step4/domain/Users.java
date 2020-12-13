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

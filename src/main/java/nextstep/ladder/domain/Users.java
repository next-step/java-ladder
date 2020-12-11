package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Users {
    private static final int ZERO = 0;

    private List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users createUsers(InputUsers inputUsers) {
        List<User> userList = new ArrayList<>();
        int index = 0;
        for(String userName : inputUsers.splitUsers()) {
            userList.add(User.of(userName, index++));
        }

        return new Users(userList);
    }

    public Map<User, Integer> mapUserIndex() {
        Map<User, Integer> userMap = new LinkedHashMap<>();

        IntStream.range(ZERO, users.size())
                .forEach(index -> userMap.put(users.get(index), index));
        return userMap;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

}

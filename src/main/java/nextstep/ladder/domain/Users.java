package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private List<User> userList;

    public Users(String... users) {
        this.userList = Arrays.stream(users)
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return userList.size();
    }

    public List<User> getUserList() {
        return userList;
    }
}

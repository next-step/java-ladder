package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {


    private List<User> users = new ArrayList<>();

    public Users(List<User> users) {
        this.users = users;
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public int getUserCount() {
        return this.users.size();
    }
}

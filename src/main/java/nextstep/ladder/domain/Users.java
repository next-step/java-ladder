package nextstep.ladder.domain;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Users {
    private List<User> users = new ArrayList<>();

    public Users(List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            User user = new User(names.get(i), i);
            users.add(user);
        }
    }

    public String status() {
        String result = "";
        for (User user : users) {
            result += user.getName() + " ";
        }
        return result;
    }
}

package nextstep.ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Users {
    private List<User> users = new ArrayList<>();

    public Users (List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), i));
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

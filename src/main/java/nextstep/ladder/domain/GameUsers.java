package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameUsers {

    private List<User> userList;

    public GameUsers(String[] userNames) {
        this.userList = new ArrayList<>();
        Arrays.stream(userNames)
            .forEach(userName -> userList.add(new User(userName)));
    }

    public int getUserCount() {
        return userList.size();
    }

    public List<String> getUserNames() {
        return userList.stream().map(User::getName).collect(Collectors.toList());
    }
}

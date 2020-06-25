package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameUsers {

    private static final String INVALID_USER_COUNT = "사다리 게임에 참여하는 사람은 최소 2명 이상이어야합니다.";
    private List<User> userList;

    public GameUsers(String[] userNames) {
        this.userList = new ArrayList<>();
        Arrays.stream(userNames)
            .forEach(userName -> userList.add(new User(userName)));
        validUserCount();
    }

    private void validUserCount() {
        if(userList.size() < 2) {
            throw new IllegalArgumentException(INVALID_USER_COUNT);
        }
    }

    public int getUserCount() {
        return userList.size();
    }

    public List<String> getUserNames() {
        return userList.stream().map(User::getName).collect(Collectors.toList());
    }
}

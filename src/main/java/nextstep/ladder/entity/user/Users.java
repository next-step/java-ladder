package nextstep.ladder.entity.user;

import nextstep.ladder.util.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    private final List<User> users;

    public Users(String userInput) {
        this.users = usersInit(userInput);
    }

    private List<User> usersInit(String userInput) {

        String[] users = StringUtil.splitCommaByString(userInput);

        return IntStream.range(0, users.length)
                .mapToObj(index -> new User(users[index], index))
                .collect(Collectors.toList());
    }

    public User startPositionUser(int startPosition) {
        return users.get(startPosition);
    }

    public List<String> userNames() {
        return users.stream().map(User::name)
                .collect(Collectors.toList());
    }

    private List<Integer> startPositions() {
        return users.stream().map(User::startPosition)
                .collect(Collectors.toList());
    }

    public int userCount() {
        return this.users.size();
    }

    public List<Integer> startPositions(String userName) {

        if (userName.equalsIgnoreCase("all")) {
            return startPositions();
        }

        return Collections.singletonList(users.stream()
                .filter(user -> user.name().equals(userName))
                .findFirst().map(User::startPosition)
                .orElseThrow(() -> new IllegalArgumentException("게임에 참여한 참여자의 이름이 아닙니다.")));
    }
}

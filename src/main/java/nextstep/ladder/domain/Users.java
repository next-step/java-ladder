package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    public static final int MINIMUM_USERS_COUNT = 2;
    private final List<User> users;

    public static Users from(List<String> users, List<String> winningProducts) {
        return new Users(users, winningProducts);
    }

    private Users(List<String> users, List<String> winningProducts) {
        validate(users, winningProducts);

        this.users = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            this.users.add(User.from(users.get(i), winningProducts.get(i)));
        }
    }

    private void validate(List<String> users, List<String> winningProducts) {
        if (users.size() < MINIMUM_USERS_COUNT) {
            throw new IllegalArgumentException("참여자는 2명 이상이여야 합니다.");
        }
    }

    public List<String> toNameList() {
        return users.stream()
                .map(User::name)
                .collect(Collectors.toList());
    }

    public int countOfUsers() {
        return this.users.size();
    }

    public String getWinningProductOf(String name) {

        return this.users.stream()
                .filter(user -> user.name().equals(name))
                .map(User::winningProduct)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("찾으려는 사용자는 참가하지 않았습니다."));
    }
}

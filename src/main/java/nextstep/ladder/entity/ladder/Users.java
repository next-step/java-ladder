package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Users {

    private List<User> users;

    public Users(List<User> users) {

        Optional.ofNullable(users)
                .filter(Objects::nonNull)
                .ifPresent(this::throwIfLinesLessThanTwo);

        this.users = users;
    }

    private void throwIfLinesLessThanTwo(List<User> users) {
        if (users.size() < 2) {
            throw new IllegalArgumentException("최소한 2명 이상의 참가자가 필요합니다.");
        }
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

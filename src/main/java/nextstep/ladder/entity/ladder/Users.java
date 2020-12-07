package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {

    private List<User> users;

    public Users(List<String> usersInput) {

        List<User> users = usersInput.stream()
                .map(User::new)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        throwIfLinesLessThanTwo(users);
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
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public int getUserCount() {
        return this.users.size();
    }

    public int getPosition(User user) {
        return users.indexOf(user);
    }

    public User at(int position) {
        try {
            return users.get(position - 1);
        } catch (IndexOutOfBoundsException e) {
            String message = String.format("올바르지 않은 위치값입니다. (최소 = %d, 최대 = %d)", 0, getUserCount());
            throw new IllegalArgumentException(message);
        }
    }


    public void goDownAllUsers(Ladder ladder) {
        for (User user : users) {
            ladder.goDown(user);
        }
    }
}

package ladder.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderUsers {
    public static final int MIN_USER_SIZE = 2;

    private List<User> users = new ArrayList<>();

    public LadderUsers(List<String> names) {
        validate(names);
        names.forEach(name -> users.add(User.of(Name.of(name.trim()))));
    }

    private void validate(List<String> names) {
        if (names == null || names.size() < MIN_USER_SIZE) {
            throw new IllegalArgumentException("사다리 게임의 참여자는 " + MIN_USER_SIZE + "명 이상이어야 합니다.");
        }
    }

    public static LadderUsers of(List<String> names) {
        return new LadderUsers(names);
    }

    public int getCountOfUsers() {
        return users.size();
    }

    @Override
    public String toString() {
        return this.users.stream()
                .map(User::toString)
                .collect(Collectors.joining());
    }
}

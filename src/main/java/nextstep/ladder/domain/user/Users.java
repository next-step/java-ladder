package nextstep.ladder.domain.user;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {
    private List<User> users;

    public Users(String names) {
        this.users = Stream.of(names.split(",")).map(User::new).collect(Collectors.toList());

        if (this.users.size() <= 1) {
            throw new IllegalArgumentException("유저는 2명 이상이여야 합니다.");
        }
    }

    public int getSize() {
        return users.size();
    }
}

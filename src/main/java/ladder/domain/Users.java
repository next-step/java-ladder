package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private static final String SEPERATOR = ",";
    private final List<User> users;

    public Users(final String users) {
        validateUserMinCount(users);
        this.users = Arrays.stream(users.split(SEPERATOR))
                .map(User::new)
                .collect(Collectors.toList());
    }

    private void validateUserMinCount(String users) {
        if(!users.contains(SEPERATOR)){
            throw new IllegalArgumentException("사용자는 2명 이상이어야 합니다.");
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public int getUserCount() {
        return users.size();
    }
}

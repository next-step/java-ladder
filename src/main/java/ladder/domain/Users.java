package ladder.domain;

import ladder.utils.InputUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.utils.InputUtils.BLANK;
import static ladder.utils.InputUtils.COMMA;


public class Users {

    private List<User> users;

    public Users(String usersName) {
        this(Arrays.stream(InputUtils.isEmptyOrNull(usersName).split(COMMA))
                .map(String::trim)
                .filter(text -> !text.isEmpty())
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public int getUserCount() {
        return this.users.size();
    }

    @Override
    public String toString() {
        return this.users.stream()
                .map(User::toString)
                .collect(Collectors.joining(BLANK));
    }
}

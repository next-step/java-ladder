package step04.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderUsers {
    private static final String INVALID_RESULT_USER = "참여자에 포함되어 있지 않은 유저입니다.";
    private static final String USER_ALIGN_FORMAT = "%5s ";

    private final List<LadderUser> users;

    public LadderUsers(List<LadderUser> users) {
        this.users = Collections.unmodifiableList(users);
    }

    public int getUserNumber() {
        return users.size();
    }

    public String printableUserStatus() {
        return users.stream()
                .map(LadderUser::getName)
                .map(name -> String.format(USER_ALIGN_FORMAT, name))
                .collect(Collectors.joining());
    }

    public void validateResultUser(String resultUserName) {
        if (!users.contains(new LadderUser(resultUserName))) {
            throw new IllegalArgumentException(INVALID_RESULT_USER);
        }
    }

    public boolean isEqualSize(int size) {
        return users.size() == size;
    }

    public LadderUser getUserByIndex(Integer key) {
        return users.get(key);
    }
}

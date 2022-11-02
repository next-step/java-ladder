package ladder.user;

import java.util.List;
import ladder.user.UserName;

public class UserNames {

    private final List<UserName> userNames;

    public UserNames(List<UserName> userNames) {
        valid(userNames);
        this.userNames = userNames;
    }

    private void valid(List<UserName> userNames) {
        int count = (int)userNames.stream()
            .distinct()
            .count();

        if (count != userNames.size()) {
            throw new IllegalArgumentException("유저 이름은 중복될 수 없습니다.");
        }
    }

    public int size() {
        return userNames.size();
    }

    public List<UserName> getUserNames() {
        return userNames;
    }

    public int findUserIndex(UserName userName) {
        return userNames.indexOf(userName);
    }
}

package ladder;

import java.util.List;

public class UserNames {

    private final List<UserName> userNames;

    private UserNames(List<UserName> userNames) {
        valid(userNames);
        this.userNames = userNames;
    }

    public static UserNames of(List<UserName> userNames) {
        return new UserNames(userNames);
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
}

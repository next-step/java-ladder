package nextstep.refactoring.user;

import java.util.Collections;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public int getSize() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int findIndexOfUser(User inputUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.equals(inputUser)) {
                return i;
            }
        }
        throw new IllegalArgumentException("입력된 사람이 참여하지 않았습니다.");
    }
}

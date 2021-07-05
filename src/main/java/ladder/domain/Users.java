package ladder.domain;

import java.util.List;

public class Users {
    private List<User> userList;

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public void checkDuplicateUser() {
        long checkDistinctUserCount = this.userList.stream().map(User::name).distinct().count();
        if (checkDistinctUserCount != userList.size()) {
            throw new IllegalArgumentException("중복된 User가 있습니다.");
        }
    }

}

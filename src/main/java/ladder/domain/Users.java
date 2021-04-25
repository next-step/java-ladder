package ladder.domain;

import java.util.List;

public class Users {
    private List<User> userList;

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public List<User> userList() {
        return this.userList;
    }

    public void checkDuplicateUser() {
        if (this.userList.stream().map(User::name).distinct().count() != userList.size()) {
            throw new IllegalArgumentException("중복된 User가 있습니다.");
        }
    }

    public void checkDuplicateUser2() {

        userList.forEach(u -> {
            if (this.userList.contains(u)) {
                throw new IllegalArgumentException("중복된 User가 있습니다. 중복된 USER : "+ u.name());
            }
        });
    }


}

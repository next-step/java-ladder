package ladder.domain;

import java.util.List;

public class Users {
    private List<User> userList;

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public int count() {
        return this.userList.size();
    }

    public void checkDuplicateUser() {
        long checkDistinctUserCount = this.userList.stream().map(User::name).distinct().count();
        if (checkDistinctUserCount != userList.size()) {
            throw new IllegalArgumentException("중복된 User가 있습니다.");
        }
    }

    public List<User> userList() {
        return this.userList;
    }

    public User findByName(String name) {
        return this.userList.stream()
                        .filter(user -> user.name().equals(name))
                        .findFirst()
                        .orElseThrow(()-> new IllegalArgumentException("이름에 맞는 User가 없습니다."));
    }

}

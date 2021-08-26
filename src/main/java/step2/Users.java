package step2;

import java.util.ArrayList;
import java.util.List;

public class Users  {
    private List<User> users;

    public Users(String usersName) {
        isBlank(usersName);
        setUsersName(usersName);
    }

    private void isBlank(String usersName) {
        if (usersName == null || usersName.trim().isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 다시 입력해주세요");
        }
    }

    private void setUsersName(String usersName) {
        this.users = new ArrayList<>();
        String[] names = usersName.split(",");
        for (String name : names) {
            this.users.add(new User(name));
        }
    }

    public int getNumberOfUsers() {
        return this.users.size();
    }
}

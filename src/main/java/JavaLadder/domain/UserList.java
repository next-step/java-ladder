package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static final String REGEX = ",";
    private List<User> userList = new ArrayList<>();

    public UserList(String inputValue) {
        String[] splitInputValue = inputValue.split(REGEX);
        for (int i = 0; i < splitInputValue.length; i++) {
            User user = new User(splitInputValue[i]);
            this.userList.add(user);
        }
    }

    public int size() {
        return this.userList.size();
    }

    public String getName(int index) {
        return userList.get(index).getName();
    }
}
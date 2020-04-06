package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final String REGEX = ",";
    private List<User> userList = new ArrayList<>();

    public Users(String inputValue) {
        String[] splitInputValue = inputValue.split(REGEX);
        for (int i = 0; i < splitInputValue.length; i++) {
            User user = new User(splitInputValue[i], i);
            this.userList.add(user);
        }
    }

    public int size() {
        return this.userList.size();
    }

    public String getName(int index) {
        return userList.get(index).getName();
    }

    public Point getUserPoint(String name) {
        User user = userList.stream()
                .filter(u -> u.isEqualName(name))
                .findFirst()
                .orElse(null);
        return user.getPoint();
    }

    public User getUserByName(String name) {
        return userList.stream()
                .filter(u -> u.isEqualName(name))
                .findFirst()
                .orElse(null);
    }

    public User getUser(int index){
        return userList.get(index);
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }
}

package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users = new ArrayList<>();

    public Users(String inputNames) {
        splitNames(inputNames);
    }

    private void splitNames(String inputNames) {
        String[] splitNames = inputNames.split(",");
        for (String splitName : splitNames) {
            User user = new User(splitName);
            validateDuplicate(user);
            users.add(user);
        }
    }

    private void validateDuplicate(User user) {
        if (users.contains(user)) {
            throw new IllegalArgumentException("중복된 사용자입니다.");
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public int size() {
        return users.size();
    }
}

package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private static final String DELIMITER = ",";
    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }
    public List<User> unmodifiableUsers() {
        return Collections.unmodifiableList(users);
    }

    public static Users splitUsers(String input) {
        return new Users(Arrays.stream(input.split(DELIMITER))
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public User userByIndex(int index) {
        return users.get(index);
    }

    public void userSwap(int prevIndex, int currentIndex) {
        Collections.swap(users, prevIndex, currentIndex);
    }

    public int getUsersSize() {
        return users.size();
    }


}

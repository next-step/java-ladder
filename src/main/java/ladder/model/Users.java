package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Users {

    private final List<User> users;

    public Users(String userNmaes) {
        users = createUsers(userNmaes);
    }

    public int userCount() {
        return this.users.size();
    }

    public int userIndex(User targetUser) {
        return users.indexOf(targetUser);
    }

    public boolean isContainsUser(User targetUser) {
        return users.contains(targetUser);
    }

    public int getMaxUserNameLength() {
        return users.stream()
                    .map(User::getNameLength)
                    .max(Integer::compare)
                    .get();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(this.users);
    }

    private List <User> createUsers(String userNmaes) {
        return Arrays.asList(userNmaes.split(","))
                     .stream()
                     .map(User::new)
                     .collect(toList());
    }

}

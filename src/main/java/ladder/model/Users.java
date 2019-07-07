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

    public int userIndex(User targetUser){
        return users.indexOf(targetUser);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(this.users);
    }


    public int getMaxUserNameLength() {
        return users.stream()
                    .map(User::getNameLength)
                    .max(Integer::compare)
                    .get();
    }

    private List<User> createUsers(String userNmaes) {
        List<String> users = Arrays.asList(userNmaes.split(","));
        return users.stream()
                    .map(User::new)
                    .collect(toList());
    }

}

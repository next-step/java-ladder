package nextstep.ladder.domain.user;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserCollection {
    private final List<User> users;

    private UserCollection(List<User> users) {
        this.users = users;
    }

    public static UserCollection of(List<String> userNames) {
        List<User> users = userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
        return new UserCollection(users);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int getIndex(String userName) {

        List<String> userNames = users.stream()
                .map(User::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());

        return userNames.indexOf(userName);
    }

    public User getUserFromIndex(int index){
        return users.get(index);
    }

    public int size(){
        return users.size();
    }


}

package step3.factory;

import step3.Position;
import step3.User;
import step3.Users;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NamedUsersFactory implements UsersFactory {
    private final List<String> usernames;

    public NamedUsersFactory(List<String> names) {
        this.usernames = names;
    }

    @Override
    public Users createUsers() {
        List<User> users = IntStream.range(0, usernames.size())
                .mapToObj(i -> new User(usernames.get(i), new Position(i)))
                .collect(Collectors.toList());

        return new Users(users);
    }
}

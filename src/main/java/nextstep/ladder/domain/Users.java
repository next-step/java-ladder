package nextstep.ladder.domain;


import nextstep.ladder.StringParser;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(String names) {
        this.users = createUsers(names);
    }

    private List<User> createUsers(String input) {
        List<String> names = StringParser.splits(input);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), i));
        }
        return users;
    }

    public int getCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public List<String> getNames(){
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}

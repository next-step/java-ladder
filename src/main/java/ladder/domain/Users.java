package ladder.domain;

import ladder.utils.InputUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final String COMMA = ",";
    private List<User> users;

    public Users(String usersName){
        this(Arrays.stream(usersName.split(COMMA))
                .map(String::trim)
                .filter(text -> !text.isEmpty())
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public Users(List<User> users){
        this.users = users;
    }

}

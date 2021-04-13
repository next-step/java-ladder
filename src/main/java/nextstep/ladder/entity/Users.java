package nextstep.ladder.entity;

import nextstep.ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(String userInput) {
        this.users = usersInit(userInput);
    }

    private List<User> usersInit(String userInput) {
        return Arrays.stream(StringUtil.splitCommaByString(userInput))
                     .map(User::new).collect(Collectors.toList());
    }

    public List<String> userNames(){
        return users.stream().map(User::getName)
                .collect(Collectors.toList());
    }

    public int userCount(){
        return this.users.size();
    }
}

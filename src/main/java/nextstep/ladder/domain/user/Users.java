package nextstep.ladder.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users of(String ... users){
       return new Users(
           Arrays.stream(users)
               .map(User::of)
               .collect(Collectors.toList())
       );
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int index){
        return users.get(index);
    }

    public List<String> getUserNames() {
        return users.stream().map(User::getName).collect(Collectors.toList());
    }

    public static Users join(String... usersNames) {
        return new Users(
            Arrays.stream(usersNames)
                .map(User::of)
                .collect(Collectors.toList())
        );
    }

    public static Users join(List<String> userNames){
        return new Users(
            userNames.stream()
                .map(User::of)
                .collect(Collectors.toList())
        );
    }

    public int numberOfUsers(){
        return users.size();
    }
}

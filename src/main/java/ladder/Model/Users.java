package ladder.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Users {

    private List<User> users;

    public Users(String userNmaes){
        users = createUsers(userNmaes);
    }

    private List<User> createUsers(String userNmaes){
        List<String> users = Arrays.asList(userNmaes.split(","));
        return users.stream()
                    .map(name -> new User(name))
                    .collect(Collectors.toList());
    }

}

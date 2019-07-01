package ladder.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(String userNmaes){
        users = createUsers(userNmaes);
    }

    public int userCount(){
        return this.users.size();
    }

    public List<User> getUsers(){
        return this.users;
    }

    private List<User> createUsers(String userNmaes){
        List<String> users = Arrays.asList(userNmaes.split(","));
        return users.stream()
                    .map(name -> new User(name))
                    .collect(Collectors.toList());
    }

}

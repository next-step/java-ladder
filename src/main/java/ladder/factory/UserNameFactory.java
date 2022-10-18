package ladder.factory;

import ladder.domain.UserName;
import ladder.domain.Users;
import nextstep.optional.User;

import java.util.List;

public class UserNameFactory {

    public static final String ALL_USER = "all";

    public static List<UserName> getUserName(Users users, String name){
        if (name.equals(ALL_USER)){
            return users.findAllUserName();
        }
        return List.of(new UserName(name));
    }
}

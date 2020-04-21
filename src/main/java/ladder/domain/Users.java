package ladder.domain;

import java.util.List;

public class Users {
    private Users(List<String> userNames) {

    }

    public static Users getInstanceByUserNames(String[] userNames) {
        return new Users(userNames);
    }
}

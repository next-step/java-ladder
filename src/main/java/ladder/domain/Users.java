package ladder.domain;

public class Users {
    private Users(String[] userNames) {

    }

    public static Users getInstanceByUserNames(String[] userNames) {
        return new Users(userNames);
    }
}

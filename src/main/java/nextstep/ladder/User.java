package nextstep.ladder;

public class User {
    private final String userName;
    private final int MAX_USER_NAME_LENGTH = 5;

    private User(String userName) {
        if(userName.length() > MAX_USER_NAME_LENGTH){
            throw new IllegalArgumentException("exceeded max user name length");
        }
        this.userName = userName;
    }

    public static User of(String userName){
        return new User(userName);
    }

    @Override
    public String toString() {
        return userName;
    }
}

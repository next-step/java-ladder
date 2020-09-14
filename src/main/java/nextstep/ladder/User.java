package nextstep.ladder;

public class User {
    private final String userName;
    private final int MAX_USER_NAME_LENGTH = 5;
    public User(String userName) {
        if(userName.length() > MAX_USER_NAME_LENGTH){
            throw new IllegalArgumentException("exceeded max user name length");
        }
        this.userName = userName;
    }

    @Override
    public String toString() {
        return String.format("%5.5s", userName);
    }
}

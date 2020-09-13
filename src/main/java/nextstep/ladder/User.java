package nextstep.ladder;

public class User {
    private final String userName;

    public User(String userName) {
        if(userName.length() > 5){
            throw new IllegalArgumentException("exceeded max user name length");
        }
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userName;
    }
}

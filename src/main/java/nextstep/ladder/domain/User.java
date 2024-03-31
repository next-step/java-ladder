package nextstep.ladder.domain;

public class User {
    private final UserName userName;

    public User(String userName) {
        this.userName = new UserName(userName);
    }


    public String getUserName() {
        return userName.getName();
    }
}

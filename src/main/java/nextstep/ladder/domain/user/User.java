package nextstep.ladder.domain.user;

public class User {
    private UserName userName;
    public User(UserName userName) {
        this.userName = userName;
    }

    public String getName() {
        return userName.getUserName();
    }
}

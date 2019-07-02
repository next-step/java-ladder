package nextstep.ladder;

public class User {
    private String userName;

    public User(String userName) {
        if (userName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하입니다.");
        }
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }
}

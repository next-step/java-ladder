package nextstep.ladder;

public class User {
    private static final int maxLengthOfName = 5;
    private String userName;

    public User(String userName) {
        if (userName.length() > maxLengthOfName) {
            throw new IllegalArgumentException("이름은 5자 이하입니다.");
        }
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }
}

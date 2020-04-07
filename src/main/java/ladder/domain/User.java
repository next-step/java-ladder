package ladder.domain;

public class User {
    private final String userName;

    public User(String userName) {
        userNameValidation(userName);
        this.userName = userName;
    }

    private void userNameValidation(String userName) {
        if (userName.length() > 5) {
            throw new IllegalArgumentException("참가자의 이름은 최대 5글자까지 허용됩니다.");
        }
    }

    @Override
    public String toString() {
        return userName;
    }
}

package nextstep.ladder.domain;

public class User {
    private final String userName;
    private static final String USER_INVAILD_MESSEAGE = "잘못된 유저명 입니다";

    public User(String userName) {
        checkValidName(userName);
        this.userName = userName;
    }

    private static void checkValidName(String userName) {
        if (userName == null || userName.isEmpty() || userName.isBlank()) {
            throw new IllegalArgumentException(USER_INVAILD_MESSEAGE);
        }

        if (userName.length() > 5) {
            throw new IllegalArgumentException(USER_INVAILD_MESSEAGE);
        }
    }
}

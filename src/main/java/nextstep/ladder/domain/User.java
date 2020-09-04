package nextstep.ladder.domain;

import static nextstep.ladder.constant.ExceptionMessage.INVALID_USER_NAME_LENGTH_UNDER_FIVE;

public class User {

    private String userName;

    private final String NAME_FIXED_SIX_SPACE = "      ";

    private final int MAXIMUM_USER_NAME_LENGTH = 5;

    private User(String userName) {
        this.userName = userName;

        if (userName.length() > MAXIMUM_USER_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_USER_NAME_LENGTH_UNDER_FIVE);
        }
    }

    public static User join(String name) {
        return new User(name.trim());
    }

    public String getFixedLengthUserName() {
        StringBuilder fixedLengthUserName = new StringBuilder();
        String newPrefix = NAME_FIXED_SIX_SPACE.substring(userName.length());
        fixedLengthUserName.append(userName).append(newPrefix);

        return fixedLengthUserName.toString();
    }


}

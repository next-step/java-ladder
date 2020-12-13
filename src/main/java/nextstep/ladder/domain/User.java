package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

public class User {

    private static final int EMPTY = 0;
    private static final int MAX = 5;

    private final String name;

    public User(String name) {
        throwIfInvalidName(name);
        this.name = name;
    }

    private void throwIfInvalidName(String name) {
        if (name == null || name.length() == EMPTY || name.length() > MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USER_NAME);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != User.class) return false;
        User user = (User) obj;
        return name.equals(user.name);
    }
}

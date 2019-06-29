package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.User;
import com.jaeyeonling.ladder.Users;

public class UsersFormatter implements Formatter<Users> {

    private final Formatter<User> userFormatter;

    private UsersFormatter(final Formatter<User> userFormatter) {
        this.userFormatter = userFormatter;
    }

    public static UsersFormatter of(final Formatter<User> userFormatter) {
        return new UsersFormatter(userFormatter);
    }

    @Override
    public String format(Users raw) {
        return null;
    }
}

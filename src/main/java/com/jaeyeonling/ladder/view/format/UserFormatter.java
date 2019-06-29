package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.User;
import com.jaeyeonling.ladder.Username;

public class UserFormatter implements Formatter<User> {

    private static final String FORMAT = String.format("%s%d%s", "%", Username.MAX_LENGTH, "s");

    private final Formatter<Username> usernameFormatter;

    private UserFormatter(final Formatter<Username> usernameFormatter) {
        this.usernameFormatter = usernameFormatter;
    }

    public static UserFormatter of(final Formatter<Username> usernameFormatter) {
        return new UserFormatter(usernameFormatter);
    }

    @Override
    public String format(final User user) {
        final String formattedUsername = usernameFormatter.format(user.getUsername());
        return String.format(FORMAT, formattedUsername);
    }
}

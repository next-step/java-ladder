package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.utils.StringUtils;

public class UserFormatter implements Formatter<User> {

    private final Formatter<Username> usernameFormatter;

    private UserFormatter(final Formatter<Username> usernameFormatter) {
        this.usernameFormatter = usernameFormatter;
    }

    public static UserFormatter withUsernameFormatter(final Formatter<Username> usernameFormatter) {
        return new UserFormatter(usernameFormatter);
    }

    @Override
    public String format(final User user) {
        final String formattedUsername = usernameFormatter.format(user.getUsername());
        return StringUtils.rightAlign(formattedUsername, Username.MAX_LENGTH);
    }
}

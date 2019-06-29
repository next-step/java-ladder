package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Users;

import java.util.stream.Collectors;

public class UsersFormatter implements Formatter<Users> {

    private final Formatter<User> userFormatter;

    private UsersFormatter(final Formatter<User> userFormatter) {
        this.userFormatter = userFormatter;
    }

    public static UsersFormatter withUserFormatter(final Formatter<User> userFormatter) {
        return new UsersFormatter(userFormatter);
    }

    @Override
    public String format(final Users users) {
        return users.stream()
                .map(userFormatter::format)
                .collect(Collectors.joining());
    }
}

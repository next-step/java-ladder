package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.Username;

public class UsernameFormatter implements Formatter<Username> {

    private static final String FORMAT = String.format("%s%d%s", "%", Username.MAX_LENGTH, "s");

    @Override
    public String format(final Username username) {
        return String.format(FORMAT, username.getUsername());
    }
}

package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.User;
import com.jaeyeonling.ladder.Username;

public class FormatterSupport {

    protected static final Formatter<Username> usernameFormatter = new UsernameFormatter();
    protected static final Formatter<User> userFormatter = UserFormatter.of(usernameFormatter);
}

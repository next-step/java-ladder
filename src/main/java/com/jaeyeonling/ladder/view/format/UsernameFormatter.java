package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.Username;

public class UsernameFormatter implements Formatter<Username> {



    @Override
    public String format(final Username username) {
        return "다섯글자다";
    }
}

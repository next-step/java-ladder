package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.Username;

public class PointFormatter implements Formatter<Boolean> {

    private static final String EMPTY = " ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";

    @Override
    public String format(final Boolean point) {
        final String replaceCharacter = pointToReplaceCharacter(point);
        return replaceCharacter.repeat(Username.MAX_LENGTH) + VERTICAL;
    }

    private String pointToReplaceCharacter(final boolean point) {
        if (point) {
            return HORIZONTAL;
        }

        return EMPTY;
    }
}

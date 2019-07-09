package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.user.Username;

public class DirectionFormatter implements Formatter<Direction> {

    private static final String EMPTY = " ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";

    @Override
    public String format(final Direction direction) {
        final String replaceCharacter = directionToReplaceCharacter(direction);
        return replaceCharacter.repeat(Username.MAX_LENGTH) + VERTICAL;
    }

    private String directionToReplaceCharacter(final Direction direction) {
        if (direction == Direction.LEFT) {
            return HORIZONTAL;
        }

        return EMPTY;
    }
}

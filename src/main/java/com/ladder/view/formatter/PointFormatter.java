package com.ladder.view.formatter;

import static com.ladder.view.formatter.LadderFormatter.*;

public class PointFormatter implements Formatter<Boolean> {

    @Override
    public String format(Boolean point) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LADDER_OF_COLUMNS);
        if (point) {
            stringBuilder.append(LADDER_OF_LINE);
        } else {
            stringBuilder.append(LADDER_OF_EMPTY);
        }
        return stringBuilder.toString();
    }
}

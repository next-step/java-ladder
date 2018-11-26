package net.chandol.domain.line;

import net.chandol.value.Positive;

public class Line {
    private Positive lineNumber;
    private Positive height;

    public Line(Positive lineNumber, Positive height) {
        this.lineNumber = lineNumber;
        this.height = height;
    }
}

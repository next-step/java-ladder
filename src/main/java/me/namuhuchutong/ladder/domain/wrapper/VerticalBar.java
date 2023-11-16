package me.namuhuchutong.ladder.domain.wrapper;

public class VerticalBar extends LadderExpression {

    private static final char VERTICAL_BAR = '|';

    public VerticalBar() {
        super(VERTICAL_BAR);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

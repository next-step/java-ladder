package me.namuhuchutong.ladder;

public class VerticalBar extends LadderExpression {

    private static final char VERTICAL_BAR = '|';

    public static VerticalBar create() {
        return new VerticalBar();
    }

    private VerticalBar() {
        super(VERTICAL_BAR);
    }
}

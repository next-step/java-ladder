package me.namuhuchutong.ladder;

public class Hyphen extends LadderExpression {

    private static final char HYPHEN = '-';

    public static Hyphen create() {
        return new Hyphen();
    }

    private Hyphen() {
        super(HYPHEN);
    }
}

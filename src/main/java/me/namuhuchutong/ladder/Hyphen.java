package me.namuhuchutong.ladder;

public class Hyphen extends LadderExpression {

    private static final char HYPHEN = '-';

    public Hyphen() {
        super(HYPHEN);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

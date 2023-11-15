package me.namuhuchutong.ladder;

public class EmptySpace extends LadderExpression {

    private static final Character EMPTY = ' ';

    protected EmptySpace() {
        super(EMPTY);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

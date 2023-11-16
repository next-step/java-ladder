package me.namuhuchutong.ladder.domain.wrapper;

public class EmptySpace extends LadderExpression {

    private static final Character EMPTY = ' ';

    public EmptySpace() {
        super(EMPTY);
    }

    @Override
    public String toString() {
        return value.toString().repeat(DEFAULT_SCAFFOLD_SIZE);
    }
}

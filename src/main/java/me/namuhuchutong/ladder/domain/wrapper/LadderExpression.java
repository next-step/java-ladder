package me.namuhuchutong.ladder.domain.wrapper;

public abstract class LadderExpression {

    protected static final int DEFAULT_SCAFFOLD_SIZE = 5;

    protected final Character value;

    protected LadderExpression(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return this.value;
    }
}

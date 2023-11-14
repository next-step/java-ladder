package me.namuhuchutong.ladder;

public abstract class LadderExpression {

    protected final Character value;

    protected LadderExpression(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return this.value;
    }
}

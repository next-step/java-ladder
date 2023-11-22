package me.namuhuchutong.ladder.domain.wrapper;

import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;

import java.util.Objects;

import static me.namuhuchutong.ladder.domain.wrapper.LadderExpression.HYPHEN;
import static me.namuhuchutong.ladder.domain.wrapper.LadderExpression.VERTICAL_BAR;

public class Point {

    private final LadderExpression ladderExpression;

    public Point(ScaffoldFactory factory) {
        this.ladderExpression = factory.createScaffold();
    }

    public Point(LadderExpression ladderExpression) {
        this.ladderExpression = ladderExpression;
    }

    public String convertToString() {
        return this.ladderExpression.convertToString();
    }

    public boolean isHyphen() {
        return this.ladderExpression.equals(HYPHEN);
    }

    public boolean isNotVerticalBar() {
        return !this.ladderExpression.equals(VERTICAL_BAR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return ladderExpression == point.ladderExpression;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderExpression);
    }
}

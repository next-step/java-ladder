package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.wrapper.LadderExpression;
import me.namuhuchutong.ladder.domain.wrapper.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("이넘값이 같다면 같은 객체이다.")
    @Test
    void if_enums_are_same_then_they_are_same_objects() {
        LadderExpression given = LadderExpression.HYPHEN;
        Point point1 = new Point(given);
        Point point2 = new Point(given);

        boolean actual = point1.equals(point2);

        assertThat(actual).isTrue();
    }

    @DisplayName("이넘값이 다르다면 다른 객체이다.")
    @Test
    void if_enums_are_not_same_then_they_are_not_same_objects() {
        LadderExpression given1 = LadderExpression.HYPHEN;
        LadderExpression given2 = LadderExpression.EMPTY_SPACE;
        Point point1 = new Point(given1);
        Point point2 = new Point(given2);

        boolean actual = point1.equals(point2);

        assertThat(actual).isFalse();
    }

    @DisplayName("")
    @Test
    void test() {
    }
}
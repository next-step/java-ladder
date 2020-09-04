package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPointTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LadderPoint ladderPoint = new LadderPoint(Point.BLANK, Point.COLUMN, Point.ROW);

        // when & then
        assertThat(ladderPoint).isEqualTo(new LadderPoint(Point.BLANK, Point.COLUMN, Point.ROW));
    }

    @DisplayName("해당 포인트가 Column인지 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderPointAndResult")
    void isColumn(LadderPoint ladderPoint, boolean expected) {
        // when & then
        assertThat(ladderPoint.isColumn()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLadderPointAndResult() {
        return Stream.of(
                Arguments.of(new LadderPoint(Point.BLANK, Point.COLUMN, Point.ROW), true),
                Arguments.of(new LadderPoint(Point.COLUMN, Point.BLANK, Point.COLUMN), false),
                Arguments.of(new LadderPoint(Point.ROW, Point.COLUMN, Point.BLANK), true),
                Arguments.of(new LadderPoint(Point.ROW, Point.BLANK, Point.ROW), false)
        );
    }

    @DisplayName("해당 포인트의 왼쪽에 길이 있는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderPointAndResult2")
    void isLeftDirection(LadderPoint ladderPoint, boolean expected) {
        // when & then
        assertThat(ladderPoint.isLeftDirection()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLadderPointAndResult2() {
        return Stream.of(
                Arguments.of(new LadderPoint(Point.BLANK, Point.COLUMN, Point.ROW), false),
                Arguments.of(new LadderPoint(Point.ROW, Point.COLUMN, Point.BLANK), true)
        );
    }

    @DisplayName("해당 포인트의 오른쪽에 길이있는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderPointAndResult3")
    void isRightDirection(LadderPoint ladderPoint, boolean expected) {
        // when & then
        assertThat(ladderPoint.isRightDirection()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLadderPointAndResult3() {
        return Stream.of(
                Arguments.of(new LadderPoint(Point.BLANK, Point.COLUMN, Point.ROW), true),
                Arguments.of(new LadderPoint(Point.ROW, Point.COLUMN, Point.BLANK), false)
        );
    }

}

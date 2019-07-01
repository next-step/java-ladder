package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @DisplayName("위치을 가지는 포인트를 생성한다")
    @ParameterizedTest
    @CsvSource({
            "true, true",
            "true, false",
            "false, true",
            "false, false"
    })
    void createPoint_success(boolean left, boolean right) {
        // when
        Point result = Point.of(left, right);

        // then
        assertThat(result).isEqualTo(Point.of(left, right));
    }

    @DisplayName("오른쪽 또는 아래로 이동하는 첫번째 위치를 생성하는데 성공한다")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    void createFirst_inputOne_success(Boolean current) {
        // when
        Point result = Point.ofFirst(current);

        // then
        assertThat(result).isEqualTo(Point.of(false, current));
    }

    @DisplayName("왼쪽 또는 이동하는 마지막 위치를 생성하는데 성공한다")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    void createLast_inputOne_success(Boolean current) {
        // when
        Point result = Point.ofLast(current);

        // then
        assertThat(result).isEqualTo(Point.of(current, false));
    }
}
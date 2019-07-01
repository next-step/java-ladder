package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.point.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionFormatterTest extends FormatterSupport {

    @DisplayName("방향 포매터 생성에 성공한다.")
    @Test
    void should_create() {
        // then
        assertThat(directionFormatter).isNotNull();
    }

    @DisplayName("방향이 LEFT 인 경우 포맷팅에 성공한다.")
    @Test
    void should_equals_true_formattedDirection_and_expectFormat_by_LEFT() {
        // when
        final String formatted = directionFormatter.format(Direction.LEFT);
        final String expect = "-----|";

        // then
        assertThat(formatted).isEqualTo(expect);
    }

    @DisplayName("방향이 RIGHT 인 경우 포맷팅에 성공한다.")
    @Test
    void should_equals_true_formattedDirection_and_expectFormat_by_RIGHT() {
        // when
        final String formatted = directionFormatter.format(Direction.RIGHT);
        final String expect = "     |";

        // then
        assertThat(formatted).isEqualTo(expect);
    }

    @DisplayName("방향이 STRAIGHT 인 경우 포맷팅에 성공한다.")
    @Test
    void should_equals_true_formattedDirection_and_expectFormat_by_STRAIGHT() {
        // when
        final String formatted = directionFormatter.format(Direction.STRAIGHT);
        final String expect = "     |";

        // then
        assertThat(formatted).isEqualTo(expect);
    }
}

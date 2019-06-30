package com.jaeyeonling.ladder.view.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointFormatterTest extends FormatterSupport {

    @DisplayName("포인트 포매터 생성에 성공한다.")
    @Test
    void should_create() {
        // then
        assertThat(pointFormatter).isNotNull();
    }

    @DisplayName("포인트가 True 인 경우 포맷팅에 성공한다.")
    @Test
    void should_equals_true_formattedPoint_and_expectFormat() {
        // given
        final boolean point = true;

        // when
        final String formatted = pointFormatter.format(point);
        final String expect = "-----|";

        // then
        assertThat(formatted).isEqualTo(expect);
    }

    @DisplayName("포인트가 False 인 경우 포맷팅에 성공한다.")
    @Test
    void should_equals_false_formattedPoint_and_expectFormat() {
        // given
        final boolean point = false;

        // when
        final String formatted = pointFormatter.format(point);
        final String expect = "     |";

        // then
        assertThat(formatted).isEqualTo(expect);
    }
}

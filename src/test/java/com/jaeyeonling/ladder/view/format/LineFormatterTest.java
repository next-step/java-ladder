package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineFormatterTest extends FormatterSupport {

    @DisplayName("라인 포매터 생성에 성공한다.")
    @Test
    void should_create() {
        // then
        assertThat(lineFormatter).isNotNull();
    }

    @DisplayName("포인트가 전부 없는 라인 포맷팅에 성공한다.")
    @Test
    void should_equals_true_formattedLine_and_expectFormat_when_allFalseLine() {
        // when
        final String formatted = lineFormatter.format(Fixture.allStraightLine);
        final String expect = "     |".repeat(Fixture.rightLeftDirection.size());

        // then
        assertThat(formatted).isEqualTo(expect);
    }

    @DisplayName("포인트가 전부 있는 라인 포맷팅에 성공한다.")
    @Test
    void should_equals_true_formattedLine_and_expectFormat_when_allTrueLine() {
        // when
        final String formatted = lineFormatter.format(Fixture.rightLeftLine);
        String expect = "     |-----|     |-----|     |";

        // then
        assertThat(formatted).isEqualTo(expect);
    }
}

package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.Fixture;
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

    @DisplayName("라인 포맷팅에 성공한다.")
    @Test
    void should_equals_true_formattedLine_and_expectFormat() {
        // when
        final String formatted = lineFormatter.format(Fixture.allFalseLine);
        final String expect = "     |".repeat(Fixture.allFalsePoint.size());

        // then
        assertThat(formatted).isEqualTo(expect);
    }
}

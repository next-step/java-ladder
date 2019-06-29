package com.jaeyeonling.ladder.view.format;

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
}

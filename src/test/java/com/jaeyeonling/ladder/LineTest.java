package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("라인 생성에 성공한다.")
    @Test
    void Create() {
        final Line line = Line.of(0);

        assertThat(line).isNotNull();
    }
}

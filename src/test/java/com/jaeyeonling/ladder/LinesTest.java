package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("라인들 생성을 성공한다.")
    @Test
    void should_create() {
        final List<Line> rawLines = List.of(Fixture.allFalseLine, Fixture.allTrueLine);

        final Lines lines = Lines.of(rawLines);

        assertThat(lines).isNotNull();
    }
}

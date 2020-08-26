package com.hskim.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        Lines lines = Lines.of(5, 6, (bound) -> Arrays.asList(1, 3, 5));

        // when & then
        assertThat(lines).isEqualTo(Lines.of(5, 6, (bound) -> Arrays.asList(1, 3, 5)));
    }
}

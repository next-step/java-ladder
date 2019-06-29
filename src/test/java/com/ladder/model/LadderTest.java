package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리 높이(행)과 사람 수(열)을 기준으로 사다리를 생성한다")
    @Test
    void createLadder_success() {
        // given
        int numberOfLines = 4;
        int numberOfColumns = 6;

        // when
        Ladder ladder = Ladder.generate(numberOfColumns, numberOfLines);

        // then
        assertThat(ladder).isNotNull();
        assertThat(ladder.getLines()).hasSize(numberOfColumns);
        assertThat(ladder.getLines().get(0).getPoints()).hasSize(numberOfLines);
    }
}

package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayReportTest {

    @DisplayName("사다리 탄 결과 리포트를 작성한다")
    @Test
    void createPlayReport_success() {
        // given
        List<Position> playingResult = Arrays.asList(Position.of(2), Position.of(1), Position.of(3));

        // when
        PlayReport playReport =  PlayReport.of(playingResult);

        // then
        assertThat(playReport).isNotNull();
    }
}
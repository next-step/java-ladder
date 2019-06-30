package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("랜덤한 위치를 갖는 한 개의 라인을 생성한다")
    @Test
    void createLine_success() {
        // given
        int numberOfPlayers = 5;

        // when
        Line points = Line.of(numberOfPlayers);

        // then
        assertThat(points).isNotNull();
        assertThat(points.getPoints()).hasSize(numberOfPlayers);
    }

    @DisplayName("위치를 갖는 한 개의 라인을 생성한다")
    @Test
    void createLine_hasStrategy_success() {
        // given
        int numberOfPlayers = 2;

        // when
        Line points = Line.of(numberOfPlayers, () -> true);

        // then
        assertThat(points).isNotNull();
        assertThat(points.getPoints()).containsExactly(true, false);
    }

}

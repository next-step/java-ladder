package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ladder.model.Point.POINT_DOWN;
import static com.ladder.model.Point.POINT_LEFT;
import static com.ladder.model.Point.POINT_RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @DisplayName("사다리 높이(행)과 사람 수(열)을 기준으로 사다리를 생성한다")
    @Test
    void createLadder_success() {
        // given
        int numberOfPlayers = 4;
        int numberOfColumns = 6;

        // when
        LadderGame ladderGame = LadderGame.generate(numberOfColumns, numberOfPlayers);

        // then
        assertThat(ladderGame).isNotNull();
        assertThat(ladderGame.getLadder()).hasSize(numberOfColumns);
        assertThat(ladderGame.getLadder().get(0).getPoints()).hasSize(numberOfPlayers);
    }

    @DisplayName("사다리를 실행한 결과를 반환한다")
    @Test
    void play_() {
        // given
        String seachPlayerName = "pobi";

        // when
        List linesList = new ArrayList();
        linesList.add(Line.of(Arrays.asList(POINT_RIGHT, POINT_LEFT, POINT_RIGHT, POINT_LEFT)));
        linesList.add(Line.of(Arrays.asList(POINT_RIGHT, POINT_LEFT, POINT_DOWN, POINT_DOWN)));
        linesList.add(Line.of(Arrays.asList(POINT_DOWN, POINT_DOWN, POINT_RIGHT, POINT_LEFT)));
        Lines lines = Lines.of(linesList);
        LadderGame ladderGame = new LadderGame(3, lines);
        PlayReport result = ladderGame.play();

        // then
        assertThat(result.getPlayResult(Position.of(1))).isEqualTo(Position.of(1));
    }
}

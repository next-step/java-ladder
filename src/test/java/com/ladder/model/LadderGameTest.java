package com.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ladder.model.Direction.*;
import static com.ladder.model.LineTest.ofLine;
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
    void play_inputPlayersWithRewards_success() {
        // given
        Players players = Players.of("a,b,c,d");
        Rewards rewards = Rewards.of("꽝,1등,2등,꽝");

        // when
        List<Line> linesList = new ArrayList<>();
        linesList.add(ofLine(RIGHT, LEFT, RIGHT, LEFT));
        linesList.add(ofLine(RIGHT, LEFT, DOWN, DOWN));
        linesList.add(ofLine(DOWN, DOWN, RIGHT, LEFT));
        Lines lines = Lines.of(linesList);

        LadderGame ladderGame = new LadderGame(lines);
        PlayReport result = ladderGame.play(Result.of(players, rewards));

        // then
        assertThat(result).isNotNull();
    }
}
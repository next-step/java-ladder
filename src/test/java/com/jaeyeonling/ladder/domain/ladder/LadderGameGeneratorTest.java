package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.Fixture;
import com.jaeyeonling.ladder.domain.line.LineGenerator;
import com.jaeyeonling.ladder.domain.line.StrategyBaseLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameGeneratorTest {

    @DisplayName("사다리 게임 생성기 생성을 성공한다.")
    @Test
    void should_create() {
        // given
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(() -> true);

        // when
        final LadderGameGenerator ladderGameGenerator = LadderGameGenerator.of(lineGenerator);

        // then
        assertThat(ladderGameGenerator).isNotNull();
    }

    @DisplayName("사다리 게임 생성기를 통해 사다리 게임 생성을 성공한다.")
    @Test
    void should_create_ladderGame_by_ladderGameGenerator_when_generate() {
        // given
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(() -> true);
        final LadderGameGenerator ladderGameGenerator = LadderGameGenerator.of(lineGenerator);
        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(10);

        // when
        final LadderGame ladderGame = ladderGameGenerator.generate(Fixture.multiUsers, heightOfLadder);

        // then
        assertThat(ladderGame).isNotNull();
    }


}

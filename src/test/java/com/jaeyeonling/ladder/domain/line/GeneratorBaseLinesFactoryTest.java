package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorBaseLinesFactoryTest {

    @DisplayName("사다리 공장 생성을 성공한다.")
    @Test
    void should_create() {
        // given
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(() -> true);

        // when
        final LinesFactory linesFactory = GeneratorBaseLinesFactory.withLineGenerator(lineGenerator);

        // then
        assertThat(linesFactory).isNotNull();
    }

    @DisplayName("사다리 공장을 통해 사다리 생성을 성공한다.")
    @Test
    void should_create_ladderGame_by_ladderGameGenerator_when_generate() {
        // given
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(() -> true);
        final LinesFactory linesFactory = GeneratorBaseLinesFactory.withLineGenerator(lineGenerator);
        final HeightOfLadder heightOfLadder = HeightOfLadder.valueOf(10);

        // when
        final Lines lines = linesFactory.create(Fixture.gameInfo, heightOfLadder);

        // then
        assertThat(lines).isNotNull();
    }


}

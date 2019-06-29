package com.jaeyeonling.ladder.domain.ladder;

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
}

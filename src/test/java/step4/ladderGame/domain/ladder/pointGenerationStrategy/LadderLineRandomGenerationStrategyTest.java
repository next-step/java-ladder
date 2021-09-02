package step4.ladderGame.domain.ladder.pointGenerationStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.ladderGame.domain.ladder.Point;
import step4.ladderGame.domain.ladder.pointGenerationStrategy.LadderLineRandomGenerationStrategy;
import step4.ladderGame.domain.ladder.pointGenerationStrategy.LadderLineGenerationStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineRandomGenerationStrategyTest {

    @DisplayName("이전 좌표에 선이 있으면 Point-false 반환")
    @Test
    void createHorizontalLine_이전_좌표에_선이_있으면_false_반환() {
        LadderLineGenerationStrategy ladderLineGenerationStrategy = new LadderLineRandomGenerationStrategy();
        assertThat(ladderLineGenerationStrategy.createLadderLine(new Point())).isFalse();
    }

}
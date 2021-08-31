package step3.ladderGame.domain.ladder.pointGenerationStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.ladderGame.domain.ladder.Point;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LadderRandomGenerationStrategyTest {

    @DisplayName("이전 좌표에 선이 있으면 Point-false 반환")
    @Test
    void createHorizontalLine_이전_좌표에_선이_있으면_false_반환() {
        horizontalLineGenerationStrategy horizontalLineGenerationStrategy = new horizontalLineRandomGenerationStrategy();
        assertThat(horizontalLineGenerationStrategy.createHorizontalLine(new Point(true))).isFalse();
    }

}

package nextstep.ladder.domain.ladder.line.strategy;

import nextstep.ladder.domain.ladder.line.HorizontalLines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HorizontalLinesGenerateRandomStrategyTest {

    private HorizontalLinesGenerateRandomStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new HorizontalLinesGenerateRandomStrategy(4, 5);
    }

    @Test
    @DisplayName("generate 테스트")
    void generateTest() {
        HorizontalLines horizontalLines = strategy.generate();
        assertThat(horizontalLines.size()).isGreaterThan(0);
    }

}
package step4.ladderGame.domain.ladder;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateRandomDirectionStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    private static final GenerateRandomDirectionStrategy generateStrategy = new GenerateRandomDirectionStrategy();

    @DisplayName("생성")
    @Test
    public void init() {
        assertThat(LadderLine.init(5, generateStrategy)).isInstanceOf(LadderLine.class);
    }

    @Disabled
    @DisplayName("이동")
    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, generateStrategy);
        assertThat(line.move(0)).isEqualTo(0);
    }

}
package step2.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.ladderGame.domain.ladder.pointGenerationStrategy.horizontalLineRandomGenerationStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("생성")
    @Test
    void create() {
        Ladder ladder = new Ladder(5, new horizontalLineRandomGenerationStrategy(), 5);
        assertThat(ladder).isInstanceOf(Ladder.class);
    }

}

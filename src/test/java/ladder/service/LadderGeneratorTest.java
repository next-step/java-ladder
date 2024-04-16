package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGeneratorTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    public void createLadderTest() {
        Ladder ladder = LadderGenerator.generateLadder(5, 4);

        assertNotNull(ladder);
        assertThat(ladder.iterator().next()).isInstanceOf(Line.class);
    }
}
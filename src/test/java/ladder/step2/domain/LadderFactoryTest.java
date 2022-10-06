package ladder.step2.domain;

import ladder.step2.dto.LadderHeightDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {
    @Test
    @DisplayName("사다리 생성")
    void create_ladder() {
        Ladder ladder = LadderFactory.of(4, new LadderHeightDTO("5"), countOfPlayers -> LineTest.LINE);
        assertThat(ladder).isNotNull();
    }
}
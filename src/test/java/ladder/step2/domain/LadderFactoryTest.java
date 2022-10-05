package ladder.step2.domain;

import ladder.step2fixture.domain.LineFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {
    @Test
    @DisplayName("사다리 생성")
    void create_ladder() {
        Ladder ladder = LadderFactory.of(4, 5, countOfPlayers -> LineFixture.LINE);
        assertThat(ladder).isNotNull();
    }
}
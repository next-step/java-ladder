package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    public void create() {
        Ladder ladder = Ladder.of(3, 5);
        assertThat(ladder.size()).isEqualTo(5);

    }
}
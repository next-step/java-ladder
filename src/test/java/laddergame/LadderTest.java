package laddergame;

import laddergame.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("Ladder 생성 테스트")
    @Test
    void LadderConstructorTest() {
        Ladder ladder = new Ladder(5, 5);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

}

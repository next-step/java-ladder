package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("높이 값으로 사다리를 생성한다")
    void shouldCreateLadder() {
        Ladder ladder = new Ladder(1);
        assertThat(ladder).isEqualTo(new Ladder(1));
    }
}
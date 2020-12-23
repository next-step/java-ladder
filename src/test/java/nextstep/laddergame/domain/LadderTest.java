package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    void create() {
        int participantCount = 4;
        int ladderHeight = 5;
        Ladder ladder = Ladder.of(participantCount, ladderHeight);
        assertThat(ladder).isNotNull();

    }

    @Test
    @DisplayName(value = "사다리의 높이는 최소 2 이상이여야 한다.")
    void ladderHeight_LessThanTwo() {
        assertThatThrownBy(() -> Ladder.of(10,1))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void runLadderByIndex() {
        int participantCount = 2;
        int ladderHeight = 2;
        Ladder ladder = Ladder.of(participantCount, ladderHeight);

        assertThat(ladder.runLadderByIndex(0)).isIn(0,1);

    }
}
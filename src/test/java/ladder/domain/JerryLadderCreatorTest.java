package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.LineCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.domain.JerryLadderCreator.MIN_HEIGHT;
import static ladder.domain.JerryLineCreator.MIN_WIDTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class JerryLadderCreatorTest {
    @Test
    void 생성검증() {
        LineCreator lineCreator = new JerryLineCreator();
        assertThat((new JerryLadderCreator(lineCreator)).create(4, 5)).isInstanceOf(JerryLadder.class);
    }

    @Test
    void 높이검증() {
        assertThatThrownBy(() -> {
            LineCreator lineCreator = new JerryLineCreator();
            Ladder ladder = (new JerryLadderCreator(lineCreator)).create(1, 1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
    }
}

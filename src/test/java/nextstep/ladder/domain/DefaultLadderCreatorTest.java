package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultLadderCreatorTest {

    @DisplayName("사다리를 만들고 확인해본다")
    @Test
    void create() {
        DefaultLadderCreator defaultLadderCreator = new DefaultLadderCreator(4, 5);
        Ladder ladder = defaultLadderCreator.create();
        assertThat(ladder.getLadder()).hasSize(5);
    }
}

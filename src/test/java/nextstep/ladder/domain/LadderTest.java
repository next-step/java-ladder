package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    @DisplayName("사다리를 생성한다.")
    void create_ladder_test() {
        int ladderHeight = 5;
        int playerCount = 4;

        Ladder ladder = new Ladder(LadderGenerateFactory.findGenerator(), playerCount, ladderHeight);

        assertThat(ladder.getLines().size()).isEqualTo(ladderHeight);
    }

    @Test
    @DisplayName("사다리 높이가 1보다 작을 경우 예외가 발생한다.")
    void create_ladder_exception_test() {
        assertThatThrownBy(() ->
                new Ladder(LadderGenerateFactory.findGenerator(), 3, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

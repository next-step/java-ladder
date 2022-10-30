package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderCreatorTest {

    @DisplayName("사다리를 생성하기 위해 사람수와 높이를 입력 받는다.")
    @Test
    void create_input() {

        final LadderCreator ladderCreator = LadderCreator.of(4, 5);
        assertThat(ladderCreator).isEqualTo(LadderCreator.of(4, 5));
    }

    @DisplayName("입력받은 높이와 사람수만큼 사다리를 생성한다.")
    @Test
    void create_ladder_input() {
        final LadderCreator ladderCreator = LadderCreator.of(4, 5);
        final Ladder ladder = ladderCreator.create();

        final List<Line> lines = ladder.getLines();
        assertAll(
                () -> assertThat(lines).hasSize(5),
                () -> assertThat(lines.get(0).getPoints()).hasSize(4)
        );
    }
}

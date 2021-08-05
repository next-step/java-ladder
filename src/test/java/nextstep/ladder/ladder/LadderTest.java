package nextstep.ladder.ladder;

import nextstep.ladder.ladder.stub.AlwaysAddLadderStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 높이 만큼 사다리를 생성한다.")
    @Test
    void create_ladder() {
        Ladder ladder = Ladder.of(LadderBound.of(4, 5), new AlwaysAddLadderStrategy());

        assertThat(ladder.getLines()).hasSize(5);
    }
}

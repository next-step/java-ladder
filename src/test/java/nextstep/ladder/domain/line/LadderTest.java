package nextstep.ladder.domain.line;

import nextstep.ladder.domain.game.LadderSize;
import nextstep.ladder.domain.line.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("입력받은 높이만큼의 사다리가 만들어진다.")
    @Test
    void height() {
        LadderSize ladderSize = new LadderSize(4, 2);
        Ladder ladder = Ladder.valueOf(ladderSize);
        assertThat(ladder.height()).isEqualTo(ladderSize.getHeight());
    }
}

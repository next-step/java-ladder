package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @Test
    void 사다리_생성() {
        int countOfPerson = 3;
        int ladderHeight = 5;
        Ladder ladder = new Ladder(countOfPerson, ladderHeight);
        List<Boolean> errorLine = Arrays.asList(true, true);

        Line firstLine = ladder.getLines().get(0);
        assertThat(firstLine.getPoints()).isNotEqualTo(errorLine);
    }

    @Test
    void 사다리_높이_예외() {
        int countOfPerson = 3;
        int ladderHeight = 0;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(countOfPerson, ladderHeight));
    }
}
package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderLineCreatorTest {
    @DisplayName("LadderLineCreatorTest 는 playCount 만큼 Point를 생성한다.")
    @Test
    void create() {
        LadderLineCreator ladderLineCreator = new LadderLineCreator();
        LadderLine ladderLine = ladderLineCreator.create(3, () -> true);
        assertThat(ladderLine).isEqualTo(new LadderLine(Arrays.asList(
                new Point(0, Direction.of(FALSE, TRUE)),
                new Point(1, Direction.of(TRUE, FALSE)),
                new Point(2, Direction.of(FALSE, FALSE)
                ))));
    }
}

package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {
    @Test
    void create() {
        Ladder ladder = LadderCreator.create(new LadderInfo(3, 2), () -> true);
        assertThat(ladder).isEqualTo(new Ladder(Arrays.asList(
                new LadderLine(Arrays.asList(
                        new Point(0, Direction.of(FALSE, TRUE)),
                        new Point(1, Direction.of(TRUE, FALSE)),
                        new Point(2, Direction.of(FALSE, FALSE))
                )),
                new LadderLine(Arrays.asList(
                        new Point(0, Direction.of(FALSE, TRUE)),
                        new Point(1, Direction.of(TRUE, FALSE)),
                        new Point(2, Direction.of(FALSE, FALSE))
                ))
        ), 3));
    }
}

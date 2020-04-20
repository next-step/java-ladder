package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        /**
         *  0   1   2
         *  |---|   |
         *  |   |---|
         */
        ladder = new Ladder(Arrays.asList(
                new LadderLine(Arrays.asList(
                        new Point(0, Direction.of(FALSE, TRUE)),
                        new Point(1, Direction.of(TRUE, FALSE)),
                        new Point(2, Direction.of(FALSE, FALSE))
                )),
                new LadderLine(Arrays.asList(
                        new Point(0, Direction.of(FALSE, FALSE)),
                        new Point(1, Direction.of(FALSE, TRUE)),
                        new Point(2, Direction.of(TRUE, FALSE))
                ))
        ));
    }

    @Test
    void move() {
        Map<Position, Position> results = new HashMap<>();
        results.put(new Position(0), new Position(2));
        results.put(new Position(1), new Position(0));
        results.put(new Position(2), new Position(1));

        assertThat(ladder.exec(3)).isEqualTo(new LadderResults(results));
    }
}

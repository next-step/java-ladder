package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

public class LadderTest {
    @Test
    void testSuccessWhenCreateLadder() {
        List<Line> lines = List.of(
                new Line(List.of(true, false, false)),
                new Line(List.of(false, false, false)),
                new Line(List.of(false, true, false))
        );

        assertThatNoException().isThrownBy(() -> new Ladder(lines));
    }
}

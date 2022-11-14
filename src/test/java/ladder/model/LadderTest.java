package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    void testArriveAt() {
        List<Line> lines = List.of(
                new Line(List.of(true, false, false)),
                new Line(List.of(false, true, false)),
                new Line(List.of(false, true, false))
        );

        assertThatNoException().isThrownBy(() -> {
            Ladder ladder = new Ladder(lines);

            assertThat(ladder.arriveAt(0)).isEqualTo(1);
            assertThat(ladder.arriveAt(1)).isEqualTo(0);
            assertThat(ladder.arriveAt(2)).isEqualTo(2);
        });
    }
}

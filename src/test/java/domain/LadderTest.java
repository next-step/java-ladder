package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class LadderTest {
    @Test
    public void getResult() {
        // Given
        final Point first = Point.first(Movable.TRUE);
        final Point second = first.next(Movable.FALSE);

        final Line line = new Line(Arrays.asList(
                first,
                second,
                second.last()));

        Ladder ladder = new Ladder(Arrays.asList(line));

        // When
        LadderGameResult gameResult = ladder.getResult();

        // Then
        assertThat(gameResult).isEqualTo(new LadderGameResult(Arrays.asList(1, 0, 2)));
    }
}
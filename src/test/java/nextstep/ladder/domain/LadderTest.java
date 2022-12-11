package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LadderTest {

    @Test
    void play() {
        Line first = new Line(Arrays.asList(right(0), left(1), down(2)));
        Line second = new Line(Arrays.asList(down(0), right(1), left(2)));
        Line third = new Line(Arrays.asList(right(0), left(1), down(2)));
        Ladder ladder = new Ladder(List.of(first, second, third));

        PlayResults results = ladder.play(3);

        Assertions.assertThat(results.getTarget(0)).isEqualTo(2);
        Assertions.assertThat(results.getTarget(1)).isEqualTo(1);
        Assertions.assertThat(results.getTarget(2)).isEqualTo(0);
    }

    private Cross right(final int position) {
        return new Cross(position, Point.of(false, true));
    }

    private Cross left(final int position) {
        return new Cross(position, Point.of(true, false));
    }

    private Cross down(final int position) {
        return new Cross(position, Point.of(false, false));
    }
}

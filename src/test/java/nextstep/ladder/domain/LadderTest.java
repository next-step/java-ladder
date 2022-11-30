package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {

    public static final String POBI = "pobi";
    public static final String HONUX = "honux";
    public static final String CRONG = "crong";

    @Test
    void play() {
        Line first = new Line(Arrays.asList(right(0), left(1), down(2)));
        Line second = new Line(Arrays.asList(down(0), right(1), left(2)));
        Line third = new Line(Arrays.asList(right(0), left(1), down(2)));
        Ladder ladder = new Ladder(List.of(POBI, HONUX, CRONG), List.of(first, second, third));

        ladder.play();

        assertThat(ladder.move(0)).isEqualTo(new LadderResult(POBI, 2));
        assertThat(ladder.move(1)).isEqualTo(new LadderResult(HONUX, 1));
        assertThat(ladder.move(2)).isEqualTo(new LadderResult(CRONG, 0));
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

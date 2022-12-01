package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {

    static final String POBI = "pobi";
    static final String HONUX = "honux";
    static final String CRONG = "crong";
    static final String TEN_THOUSAND_WON = "10000";
    static final String FIVE_THOUSAND_WON = "5000";
    static final String FAIL = "꽝";

    @Test
    void play() {
        Line first = new Line(Arrays.asList(right(0), left(1), down(2)));
        Line second = new Line(Arrays.asList(down(0), right(1), left(2)));
        Line third = new Line(Arrays.asList(right(0), left(1), down(2)));
        Ladder ladder = new Ladder(List.of(POBI, HONUX, CRONG), List.of(first, second, third), List.of(FAIL, FIVE_THOUSAND_WON, TEN_THOUSAND_WON));

        ladder.play();

        assertThat(ladder.move(0)).isEqualTo(new LadderResult(POBI, TEN_THOUSAND_WON));
        assertThat(ladder.move(1)).isEqualTo(new LadderResult(HONUX, FIVE_THOUSAND_WON));
        assertThat(ladder.move(2)).isEqualTo(new LadderResult(CRONG, FAIL));
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

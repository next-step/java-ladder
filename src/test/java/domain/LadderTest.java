package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void goDown_테스트() {
        LadderLine line1 = LadderLine.initialize(2, () -> true);
        LadderLine line2 = LadderLine.initialize(2, () -> false);

        Ladder ladder = new Ladder(2, Arrays.asList(line1, line2));

        assertThat(ladder.goDown(Position.from(0))).isEqualTo(Position.from(1));
    }
}
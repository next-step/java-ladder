package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리_내려가기_테스트() {
        Participants participants = Participants.fromInput("a,b");
        Line line1 = Line.initialize(participants, () -> true);
        Line line2 = Line.initialize(participants, () -> false);

        Ladder ladder = new Ladder(Arrays.asList(line1, line2), participants);

        // 0     1
        // |-----|
        // |     |
        //       * expected
        assertThat(ladder.goingDown(0)).isEqualTo(1);
    }
}
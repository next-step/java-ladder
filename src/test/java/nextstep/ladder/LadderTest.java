package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LadderTest {

    @Test
    void 사다리_그리기() {
        Ladder ladder = new Ladder(1, 3);
        Line line = new Line(Arrays.asList(true, false, true));
    }
}

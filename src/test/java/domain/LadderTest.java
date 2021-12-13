package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static domain.LadderLineTest.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    public static final Ladder LADDER = new Ladder(Arrays.asList(FIRST_LINE, SECOND_LINE, THIRD_LINE));

    @Test
    void testFinalPoint() {
        assertThat(LADDER.finalPoint(0)).isEqualTo(2);
        assertThat(LADDER.finalPoint(1)).isEqualTo(0);
        assertThat(LADDER.finalPoint(2)).isEqualTo(1);
    }
}

package ladder;


import ladder.ladderexceptions.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderTest {

    @Test
    @DisplayName("생성 테스트")
    void testGenerateLadder() {
        int numUser = 5;
        int numHeight = 0;
        assertThatExceptionOfType(InvalidLadderHeightException.class)
                .isThrownBy(() -> new Ladder(numHeight, numUser));
    }

    @Test
    @DisplayName("동일 테스트")
    void testLadderEquality() {
        assertThat(new Ladder(2, 2))
                .isEqualTo(new Ladder(Arrays.asList(HorizontalLine.of(2), HorizontalLine.of(2))));
    }
}

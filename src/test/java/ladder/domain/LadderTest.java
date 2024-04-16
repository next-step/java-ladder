package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("Ladder 초기화 테스트")
    public void initLadderTest() {
        Ladder ladder = new Ladder(Arrays.asList(LineTest.LINE_1, LineTest.LINE_2));

        assertThat(ladder.getClass()).isEqualTo(Ladder.class);
        assertThat(ladder.iterator().next()).isEqualTo(LineTest.LINE_1);
    }
}
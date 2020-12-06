package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {

    @Test
    @DisplayName("동일성 테스트")
    void testEquals() {
        Rewards input = new Rewards(Arrays.asList("A", "B", "C"));
        Rewards expected = new Rewards(Arrays.asList("A", "B", "C"));

        assertThat(input).isEqualTo(expected);
    }
}

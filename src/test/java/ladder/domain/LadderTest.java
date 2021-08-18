package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("플레이어 수와 사다리 높이 확인")
    @Test
    void create() {
        Ladder ladder = new Ladder(Arrays.asList("aa", "bb", "cc", "dd", "ee"), 3);
        assertThat(ladder.getPlayers().size()).isEqualTo(5);
        assertThat(ladder.getLines().size()).isEqualTo(3);
        System.out.println(ladder.toString());
    }

}
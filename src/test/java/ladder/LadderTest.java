package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("입력한 개수에 맞게 플레이어와 사다리 높이가 생성되어야한다.")
    @Test
    void create() {
        Ladder ladder = new Ladder(Arrays.asList("aa", "bb", "cc", "dd", "ee"), 3);
        assertThat(ladder.getPlayers().size()).isEqualTo(5);
        assertThat(ladder.getLines().size()).isEqualTo(3);
        System.out.println(ladder.toString());
    }

}
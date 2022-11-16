package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("인원 수 만큼의 줄이 생성된다")
    void create() {
        Ladder targetLadder = new Ladder(5, 6, () -> true);
        assertThat(targetLadder.getLineSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("모든 가능한 경우를 연결하는 사다리 테스트")
    void generator_one_point() {
        Ladder ladder = new Ladder(5, 6, () -> true);

        assertThat(ladder.getLine(0).emptyPoints()).hasSize(2);
        assertThat(ladder.getLine(1).emptyPoints()).hasSize(0);
        assertThat(ladder.getLine(2).emptyPoints()).hasSize(0);
        assertThat(ladder.getLine(3).emptyPoints()).hasSize(0);
        assertThat(ladder.getLine(4).emptyPoints()).hasSize(0);
        assertThat(ladder.getLine(5).emptyPoints()).hasSize(2);
    }
}

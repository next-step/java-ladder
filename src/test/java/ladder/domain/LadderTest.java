package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("인원 수 만큼의 줄이 생성된다")
    void create() {
        Ladder targetLadder = new Ladder(5, 6, (lineSize, maxConnectCount, connectLine) -> {});
        assertThat(targetLadder.getLineSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("생성자를 통한 1개 가로줄 생성 확인")
    void generator_one_point() {
        Ladder targetLadder = new Ladder(5, 6, (lineSize, maxConnectCount, connectLine) -> {
            connectLine.accept(0);
        });

        assertThat(targetLadder.getLine(0).emptyPoints()).hasSize(4);
        assertThat(targetLadder.getLine(1).emptyPoints()).hasSize(4);
        assertThat(targetLadder.getLine(2).emptyPoints()).hasSize(5);
        assertThat(targetLadder.getLine(3).emptyPoints()).hasSize(5);
        assertThat(targetLadder.getLine(4).emptyPoints()).hasSize(5);
    }
}

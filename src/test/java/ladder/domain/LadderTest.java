package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("인원 수 만큼의 줄이 생성된다")
    void create() {
        Ladder targetLadder = new Ladder(5, 6, (ladder, lineCount) -> {});
        assertThat(targetLadder.getLineSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("1개 가로줄 생성 확인")
    void one_point() {
        Ladder targetLadder = new Ladder(5, 6, (ladder, lineCount) -> {});

        targetLadder.connectLine(targetLadder.getLine(2), targetLadder.getLine(3), 1);

        assertThat(targetLadder.getLine(2).hasPoint(1)).isTrue();
        assertThat(targetLadder.getLine(3).hasPoint(1)).isTrue();
    }

    @Test
    @DisplayName("생성자를 통한 1개 가로줄 생성 확인")
    void generator_one_point() {
        Ladder targetLadder = new Ladder(5, 6, (ladder, lineCount) -> {
            ladder.connectLine(ladder.getLine(0), ladder.getLine(1), 3);
        });

        assertThat(targetLadder.getLine(0).hasPoint(3)).isTrue();
        assertThat(targetLadder.getLine(1).hasPoint(3)).isTrue();
    }
}

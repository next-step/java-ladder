package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("주어진 너비와 높이 만큼 사다리를 생성한다")
    void name() {
        int width = 4;
        int height = 4;
        LadderSize ladderSize = new LadderSize(width, height);

        Ladder ladder = Ladder.generate(ladderSize, () -> true);

        Assertions.assertThat(ladder.size()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리를 타고 이동한 결과 인덱스를 반환한다")
    void moveLadder() {
        int width = 2; // 참가자 3명(0, 1, 2) → 너비는 2
        int height = 3;
        LadderSize ladderSize = new LadderSize(width, height);

        // 모든 연결을 false로 고정 (움직이지 않는 경우 테스트)
        Ladder ladder = Ladder.generate(ladderSize, () -> false);

        int startIndex = 1;
        int resultIndex = ladder.move(startIndex);

        Assertions.assertThat(resultIndex).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리를 타고 오른쪽으로 이동하는 경우를 테스트한다")
    void moveRight() {
        int width = 2;
        int height = 1;
        LadderSize ladderSize = new LadderSize(width, height);

        Ladder ladder = Ladder.generate(ladderSize, () -> true);

        int startIndex = 0;
        int resultIndex = ladder.move(startIndex);

        Assertions.assertThat(resultIndex).isEqualTo(1);
    }
}
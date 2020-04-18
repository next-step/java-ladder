package ladder.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @DisplayName("참여자 수 만큼 사다리 한줄이 생긴다 (가로줄)")
    @Test
    public void init() {
        int sizeOfPlayer = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPlayer);

        assertThat(ladderLine.size()).isEqualTo(sizeOfPlayer);
    }

    @DisplayName("사다리줄에서 현재 포지션을을 입력 후 움직이면 방향에 따라 포지션이 변경된다.")
    @Test
    public void move() {
        Point first = Point.of(0, Direction.of(FALSE, TRUE));
        Point second = Point.of(1, Direction.of(FALSE, FALSE));
        LadderLine ladderLine = LadderLine.of(Arrays.asList(first, second));

        assertThat(ladderLine.move(Index.of(0))).isEqualTo(Index.of(1));
    }

}

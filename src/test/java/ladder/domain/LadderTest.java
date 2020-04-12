package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("높이와 참여자의 수를 입력하면 사다리를 생성할 수 있다")
    @Test
    public void newLadderTest() {
        Ladder ladder = new Ladder(5, 4);

        List<LadderLine> fourLinesLadder = ladder.getLadder();

        assertThat(fourLinesLadder).hasSize(4);
        assertThatThrownBy(() -> fourLinesLadder.get(5)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("사다리의 높이는 1보다 커야 한다")
    @Test
    public void newLadderWithMinusHeightTest() {
        assertThatThrownBy(() -> new Ladder(0, 2))
                .isInstanceOf(InvalidHeightException.class)
                .hasMessageContaining("높이는 1보다 커야 합니다.");
    }

    @DisplayName("사다리 게임에 참여하는 사람은 2명 이상이어야 합니다")
    @Test
    public void newLadderWithMinusCountOfPersonTest() {
        assertThatThrownBy(() -> new Ladder(1, 1))
                .isInstanceOf(NotEnoughCountOfPersonException.class)
                .hasMessageContaining("사다리 게임을 하려면 최소 2명 이상이어야 합니다.");
    }

}

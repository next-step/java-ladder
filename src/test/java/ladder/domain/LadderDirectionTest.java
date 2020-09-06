package ladder.domain;

import ladder.domain.rule.DrawRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LadderDirectionTest {

    private Ladder ladder;

    @BeforeAll
    public void setup() {
        int rowCount = 4;
        int columnCount = 4;
        ladder = Ladder.builder()
                .rowCount(rowCount)
                .columnCount(columnCount)
                .build();

        ladder.drawLine(() -> true);
    }

    @Test
    @DisplayName("사다리에서 왼쪽으로 이동할 수 있는지 확인 테스트")
    void left_canMove() {
        assertThat(LadderDirection.LEFT.canMove(ladder, new Position(0, 0))).isFalse();
        assertThat(LadderDirection.LEFT.canMove(ladder, new Position(0, 1))).isTrue();
        assertThat(LadderDirection.LEFT.canMove(ladder, new Position(0, 2))).isFalse();
    }

    @Test
    @DisplayName("사다리에서 오른쪽으로 이동할 수 있는지 확인 테스트")
    void right_canMove() {
        assertThat(LadderDirection.RIGHT.canMove(ladder, new Position(0, 0))).isTrue();
        assertThat(LadderDirection.RIGHT.canMove(ladder, new Position(0, 1))).isFalse();
        assertThat(LadderDirection.RIGHT.canMove(ladder, new Position(0, 2))).isTrue();
        assertThat(LadderDirection.RIGHT.canMove(ladder, new Position(0, 3))).isFalse();
    }

    @Test
    void down_canMove() {
        assertThat(LadderDirection.DOWN.canMove(ladder, new Position(0, 0))).isFalse();
        assertThat(LadderDirection.DOWN.canMove(ladder, new Position(0, 1))).isFalse();
        assertThat(LadderDirection.DOWN.canMove(ladder, new Position(3, 2))).isFalse();
    }

}

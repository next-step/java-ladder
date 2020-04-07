package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private RightDirection rightDirection;
    private LineSelector lineSelector;

    @BeforeEach
    void setUp() {
        rightDirection = () -> true;
        lineSelector = (size) -> 1;
    }

    @DisplayName("입력받은 높이만큼의 사다리가 만들어진다.")
    @Test
    void height() {
        LadderSize ladderSize = new LadderSize(4, 2);
        Ladder ladder =
                Ladder.valueOf(ladderSize, lineSelector, rightDirection);
        assertThat(ladder.height()).isEqualTo(ladderSize.getHeight());
    }

    @DisplayName("세로 라인에는 하나 이상의 오른쪽 선이 있어야 한다.")
    @Test
    void hasOneOrMoreLineOnVerticalLine() {
        LadderSize ladderSize = new LadderSize(4, 5);
        Ladder ladder =
                Ladder.valueOf(ladderSize, lineSelector, rightDirection);
        int checkSize = ladderSize.getWidth() - 1;
        for (int i = 0; i < checkSize; i++) {
            boolean hasRightDirection = ladder.getVerticalLine(i).stream()
                    .anyMatch(Point::hasRightDirection);

            assertThat(hasRightDirection).isTrue();
        }
    }

    @DisplayName("가로 라인의 오른쪽 선이 연속으로 그어져서는 안된다.")
    @Test
    void shouldNotHaveHorizontalLineConsecutively() {
        LadderSize ladderSize = new LadderSize(4, 2);
        Ladder ladder =
                Ladder.valueOf(ladderSize, lineSelector, rightDirection);

        for (int i = 0; i < ladderSize.getHeight(); i++) {
            HorizontalLine horizontalLine = ladder.getHorizontalLine(i);
            checkHorizontalLineClosely(horizontalLine);
        }
    }

    void checkHorizontalLineClosely(HorizontalLine horizontalLine) {
        boolean before = false;
        for (Point point : horizontalLine) {
            assertThat((before) && (point.hasRightDirection()))
                    .isFalse();
            before = point.hasRightDirection();
        }
    }

    @DisplayName("결과를 가져온다.")
    @Test
    void getResult() {
        LadderSize ladderSize = new LadderSize(4, 2);
        Ladder ladder =
                Ladder.valueOf(ladderSize, lineSelector, rightDirection);
        assertThat(ladder.result(0)).isEqualTo(1);
        assertThat(ladder.result(1)).isEqualTo(3);
        assertThat(ladder.result(2)).isEqualTo(0);
        assertThat(ladder.result(3)).isEqualTo(2);
    }
}

package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        List<HorizontalLine> horizontalLineList = Arrays.asList(
                HorizontalLine.of(ladderSize.getWidth()),
                HorizontalLine.of(ladderSize.getWidth())
        );

        Ladder ladder =
                new Ladder(horizontalLineList, lineSelector, rightDirection);
        assertThat(ladder.height()).isEqualTo(ladderSize.getHeight());
    }

    @DisplayName("세로 라인에는 하나 이상의 오른쪽 선이 있어야 한다.")
    @Test
    void vertical() {
        LadderSize ladderSize = new LadderSize(4, 2);
        List<HorizontalLine> horizontalLineList = Arrays.asList(
                HorizontalLine.of(ladderSize.getWidth()),
                HorizontalLine.of(ladderSize.getWidth())
        );
        Ladder ladder =
                new Ladder(horizontalLineList, lineSelector, rightDirection);

        for (int i = 0; i < ladderSize.getHeight(); i++) {
            boolean hasRightDirection = ladder.vertical(i).stream()
                    .anyMatch(Point::hasRightDirection);

            assertThat(hasRightDirection).isTrue();
        }
    }

    @DisplayName("가로 라인의 오른쪽 선이 연속으로 그어져서는 안된다.")
    @Test
    void horizontal() {
        LadderSize ladderSize = new LadderSize(4, 2);
        List<HorizontalLine> horizontalLineList = Arrays.asList(
                HorizontalLine.of(ladderSize.getWidth()),
                HorizontalLine.of(ladderSize.getWidth())
        );
        Ladder ladder =
                new Ladder(horizontalLineList, lineSelector, rightDirection);


        for (int i = 0; i < ladderSize.getHeight(); i++) {
            Point before = Point.of(false);
            HorizontalLine horizontalLine = ladder.horizontal(i);
            for (Point point : horizontalLine) {
                assertThat(
                        before.hasRightDirection() && point.hasRightDirection())
                        .isFalse();
            }
        }
    }
}

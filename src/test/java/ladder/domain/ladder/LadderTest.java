package ladder.domain.ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import ladder.domain.Position;
import ladder.domain.direction.Direction;
import ladder.domain.line.Line;
import ladder.domain.point.Point;
import ladder.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

    private static final Ladder ladder;
    private static final Position ZERO = new Position(0);
    private static final Position ONE = new Position(1);
    private static final Position TWO = new Position(2);
    private static final Position THREE = new Position(3);

    static {
        /**
         * 사다리 모양
         * |-----|     |-----|
         * |     |-----|     |
         * |-----|     |     |
         * |     |-----|     |
         */
        Line firstLine = new Line(new LinkedList<>(Arrays.asList(new Point(ZERO, Direction.RIGHT), new Point(ONE, Direction.LEFT), new Point(TWO, Direction.RIGHT), new Point(THREE, Direction.LEFT))));
        Line secondLine = new Line(new LinkedList<>(Arrays.asList(new Point(ZERO, Direction.DOWN), new Point(ONE, Direction.RIGHT), new Point(TWO, Direction.LEFT), new Point(THREE, Direction.DOWN))));
        Line thirdLine = new Line(new LinkedList<>(Arrays.asList(new Point(ZERO, Direction.RIGHT), new Point(ONE, Direction.LEFT), new Point(TWO, Direction.DOWN), new Point(THREE, Direction.DOWN))));
        Line fourthLine = new Line(new LinkedList<>(Arrays.asList(new Point(ZERO, Direction.DOWN), new Point(ONE, Direction.RIGHT), new Point(TWO, Direction.LEFT), new Point(THREE, Direction.DOWN))));
        ladder = new Ladder(Arrays.asList(firstLine, secondLine, thirdLine, fourthLine));
    }

    @DisplayName("게임 플레이 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,2", "2,3", "3,0"})
    void playGame(int startIndex, int resultIndex) {
        User user = User.of(String.valueOf(startIndex), new Position(startIndex));
        assertThat(ladder.playGame(user.getStartPosition())).isEqualTo(new Position(resultIndex));
    }
}
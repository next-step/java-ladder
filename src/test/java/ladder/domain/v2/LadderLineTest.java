package ladder.domain.v2;

import ladder.domain.Position;
import ladder.external.RandomFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0,1",
            "1,0",
            "2,3",
            "3,2",
            "4,4"
    })
    void nextPosition(int position, int expected) {
        LadderLine ladderLine = new LadderLine(points());

        assertThat(ladderLine.nextPosition(new Position(position))).isEqualTo(new Position(expected));
    }

    @Test
    void bridges() {
        List<Boolean> bridges = new LadderLine(points()).bridges();

        List<Boolean> expectedBridges = List.of(TRUE, FALSE, TRUE, FALSE);
        assertThat(bridges).isEqualTo(expectedBridges);
    }

    @Test
    void init() {
        RandomFactory alwaysTrueRandomFactory = new RandomFactory() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
        LadderLine ladderLine = LadderLine.init(5, alwaysTrueRandomFactory);

        assertThat(ladderLine).isEqualTo(new LadderLine(points()));
    }

    private List<Point> points() {
        return List.of(
                new Point(new Position(0), Direction.RIGHT),
                new Point(new Position(1), Direction.LEFT),
                new Point(new Position(2), Direction.RIGHT),
                new Point(new Position(3), Direction.LEFT),
                new Point(new Position(4), Direction.NONE));
    }
}

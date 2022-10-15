package ladder.domain.line.v2;

import ladder.domain.line.ILine;
import ladder.domain.line.LineFactory;
import ladder.domain.position.Position;
import ladder.external.RandomFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLadderLineFactoryTest {

    @Test
    void create() {
        RandomFactory alwaysTrueRandomFactory = new RandomFactory() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
        LineFactory randomLadderLineFactory = new RandomLadderLineFactory(alwaysTrueRandomFactory);
        ILine line = randomLadderLineFactory.create(5);

        assertThat(line).isEqualTo(new LadderLine(points()));
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

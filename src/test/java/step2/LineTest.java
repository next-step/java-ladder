package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static step2.domain.LadderType.EMPTY;
import static step2.domain.LadderType.LEFT;
import static step2.domain.LadderType.RIGHT;

import java.util.List;
import org.junit.jupiter.api.Test;
import step2.domain.LadderType;
import step2.domain.Line;
import step2.domain.LineStrategy;

public class LineTest {

    @Test
    void createLine() {
        Line line = new Line(4, new LineStrategy() {
            @Override
            public LadderType next() {
                return EMPTY;
            }

            @Override
            public LadderType next(LadderType prev) {
                if (prev == RIGHT) {
                    return LEFT;
                }
                return EMPTY;
            }
        });
        assertFirstPoint(EMPTY, line.points().get(0));
        assertOtherPoints(EMPTY, line.points());
    }

    @Test
    void createLine2() {
        Line line = new Line(4, new LineStrategy() {
            @Override
            public LadderType next() {
                return RIGHT;
            }

            @Override
            public LadderType next(LadderType prev) {
                if (prev == RIGHT) {
                    return LEFT;
                }
                return RIGHT;
            }
        });
        assertFirstPoint(RIGHT, line.points().get(0));
        assertOtherPoints(RIGHT, line.points());
    }

    private void assertFirstPoint(LadderType expected, LadderType firstPoint) {
        assertEquals(expected, firstPoint);
    }

    private void assertOtherPoints(LadderType expected, List<LadderType> others) {
        for (int i = 0; i < others.size() - 1; ++i) {
            assertNextPoint(expected, others.get(i), others.get(i + 1));
        }
    }

    private void assertNextPoint(LadderType expected, LadderType prev, LadderType next) {
        if (prev == RIGHT) {
            assertEquals(LEFT, next);
            return;
        }
        assertEquals(expected, next);
    }
}

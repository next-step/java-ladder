package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HeeSeokLadderCreatorTest {
    private Line line1;
    private Line line2;
    private Line line3;

    @BeforeEach
    void setUp() {
        LineCreator lineCreator = new LineCreator() {
            @Override
            public Line create(int sizeOfUsers) {
                boolean[] points = new boolean[]{true, true, true, false, true, false, true};
                return new Line(sizeOfUsers, points);
            }
        };
        line1 = lineCreator.create(4);
        line2 = lineCreator.create(4);

        LineCreator lineCreator2 = new LineCreator() {
            @Override
            public Line create(int sizeOfUsers) {
                boolean[] points = new boolean[]{true, false, true, false, true, true, true};
                return new Line(sizeOfUsers, points);
            }
        };
        line3 = lineCreator2.create(4);

    }

    @Test
    @DisplayName("사다리가 생성되는지 확인")
    void makeTest() {
        LadderCreator ladderCreator = new LadderCreator() {
            @Override
            public Ladder make(int height, int countOfUsers) {
                List<Line> lineList = Arrays.asList(line1, line2, line3);
                Lines lines = new Lines(lineList);
                return new HeeSeokLadder(lines);
            }
        };
        Ladder ladder = ladderCreator.make(3, 4);
        assertThat(ladder.lines()).contains(line1, line2, line3);
    }

}

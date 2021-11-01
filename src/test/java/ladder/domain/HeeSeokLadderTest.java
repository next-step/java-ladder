package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.LadderResult;
import ladder.engine.LineCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class HeeSeokLadderTest {

    private Lines lines;
    private Users users;

    @BeforeEach
    public void setUp() {
        users = new Users(Arrays.asList(new User("tom", 0)
                , new User("garry", 2)
                , new User("soyu", 4)
                , new User("jake", 6)));

        LineCreator lineCreator = new LineCreator() {
            @Override
            public Line create(int sizeOfUsers) {
                boolean[] points = new boolean[]{true, true, true, false, true, false, true};
                return new Line(sizeOfUsers, points);
            }
        };
        Line line1 = lineCreator.create(4);
        Line line2 = lineCreator.create(4);

        LineCreator lineCreator2 = new LineCreator() {
            @Override
            public Line create(int sizeOfUsers) {
                boolean[] points = new boolean[]{true, false, true, false, true, true, true};
                return new Line(sizeOfUsers, points);
            }
        };
        Line line3 = lineCreator2.create(4);

        List<Line> lineList = Arrays.asList(line1, line2, line3);
        lines = new Lines(lineList);
    }

    @Test
    @DisplayName("사다리 게임 한사람 결과 확인")
    public void gameResultTest() {
        Ladder ladder = new HeeSeokLadder(lines);
        LadderResult ladderResult = ladder.play(users);
        assertAll(
                () -> assertThat(ladderResult.getTarget(0)).isEqualTo(0),
                () -> assertThat(ladderResult.getTarget(2)).isEqualTo(2),
                () -> assertThat(ladderResult.getTarget(4)).isEqualTo(6),
                () -> assertThat(ladderResult.getTarget(6)).isEqualTo(4)
        );
    }
}

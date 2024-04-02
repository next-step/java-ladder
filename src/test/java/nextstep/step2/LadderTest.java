package nextstep.step2;

import nextstep.step2.view.ResultView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    private Ladder ladder;
    private PointGenerator pointGenerator;

    @BeforeEach
    void setUp() {
        pointGenerator = new AlwaysTruePointGenerator();
        ladder = new Ladder(5, 4, pointGenerator);
    }

    @Test
    void 사다리를_생성한다() {
        int height = 4;
        int humanCount = 5;
        Ladder ladder = new Ladder(height, humanCount, new RandomPointGenerator());

        assertEquals(humanCount, ladder.getLines().size());
        for (Line line : ladder.getLines()) {
            assertEquals(height, line.getPoints().size());
        }
    }

    @Test
    void 마지막_선의_모든_점은_false이다() {
        int humanCount = 4;
        int height = 5;
        Ladder ladder = new Ladder(height, humanCount, new RandomPointGenerator());

        Line lastLine = ladder.getLines().get(humanCount - 1);
        for (boolean point : lastLine.getPoints()) {
            assertFalse(point);
        }
    }

    @Test
    void 선을_잇는_선은_연속해서_생성되지_않는다() {
        int height = 5;
        int humanCount = 4;
        PointGenerator pointGenerator = () -> true;

        Ladder ladder = new Ladder(height, humanCount, pointGenerator);
        List<Line> lines = ladder.getLines();

        for (int i = 1; i < lines.size(); i++) {
            Line prevLine = lines.get(i - 1);
            Line currLine = lines.get(i);

            for (int j = 0; j < height; j++) {
                assertFalse(prevLine.getPoints().get(j) && currLine.getPoints().get(j));
            }
        }
    }

    @Test
    void 모든_다리가_있는_사다리면_제일_좌측의_참가자는_두번째에_도착한다() {
        Position position = new Position(0, 0);
        int result = ladder.move(position);
        assertEquals(1, result);
    }

    @Test
    void 모든_다리가_있는_사다리면_제일_우측의_참가자는_세번째에_도착한다() {
        Position position = new Position(3, 0);
        int result = ladder.move(position);
        assertEquals(2, result);
    }

    @Test
    void 모든_다리가_있으면_두번째_참가자는_첫번째에_도착한다() {
        Position position = new Position(1, 0);
        int result = ladder.move(position);
        assertEquals(0, result);
    }

    @Test
    void 다리가_없는_사다리는_각_참가자_라인의_끝에_도달한다() {
        Ladder emptyLadder = new Ladder(3, 3, new AlwaysFalsePointGenerator());

        assertAll(
                () -> assertEquals(0, emptyLadder.move(new Position(0,0))),
                () -> assertEquals(1, emptyLadder.move(new Position(1,0))),
                () -> assertEquals(2, emptyLadder.move(new Position(2,0)))
        );
    }
}

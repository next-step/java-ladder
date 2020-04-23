package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    private LadderGoals ladderGoals;
    private Users users;
    private GameResult ladderGame;

    @BeforeEach
    void setUp() {
        ladderGoals = new GoalsGenerator("5000, 꽝").generate();
    }

    @DisplayName("사다리의 골과 사용자 숫자가 일치하는지 테스트")
    @Test
    void testGoalsAndUserCounts() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameResult(twoUsers(), new LadderGenerator(fiveHeightLadder(), fourLadderGoals()));
        });
    }

    @DisplayName("사다리 골과 게임결과가 같은지 테스트")
    @Test
    void testLadderGoal() {
        List<Boolean> width1 = Arrays.asList(true, true);
        List<Boolean> width2 = Arrays.asList(false, false);
        Line line1 = new Line(width1.size(), new WidthGenerator(width1));
        Line line2 = new Line(width2.size(), new WidthGenerator(width2));

        List<Line> lines = Arrays.asList(line1, line2);
        Ladder ladder = new Ladder(lines);
        LadderGenerator ladderGenerator = new LadderGenerator(ladder, ladderGoals);

        GameResult ladderGame = new GameResult(twoUsers(), ladderGenerator);

        String actual = ladderGame.findPlayerGoal("pobi");
        assertThat(ladderGoals.getResult(1)).isEqualTo(actual);
    }

}

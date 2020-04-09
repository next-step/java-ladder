package ladder.domain;

import ladder.domain.type.ActionType;
import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    private LadderReward reward;
    private List<LadderLine> ladderLines;

    private ActionType down = ActionType.DOWN;
    private ActionType right = ActionType.RIGHT;
    private ActionType left = ActionType.LEFT;

    @BeforeEach
    void setUp() {
        reward = new LadderReward(Arrays.asList("꽝", "5000", "꽝"));
        ladderLines = new ArrayList<>(Arrays.asList(new LadderLine(Arrays.asList(right, left, down)), new LadderLine(Arrays.asList(down, left, right))));
    }

    @Test
    void ladder_exception() {
        ladderLines.add(new LadderLine(Arrays.asList(right, left, down)));

        assertThatThrownBy(() -> new Ladder(ladderLines, reward))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_LINE_SIZE.getErrorMessage());
    }

    @Test
    void getReward() {
        Ladder ladder = new Ladder(ladderLines, reward);

        String actual = ladder.getReward(1);

        assertThat(actual).isEqualTo("꽝");
    }
}

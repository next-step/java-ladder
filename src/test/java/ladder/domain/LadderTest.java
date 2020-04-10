package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static ladder.domain.type.DirectionType.*;

public class LadderTest {
    private LadderReward reward;
    private List<LadderLine> ladderLines;

    @BeforeEach
    void setUp() {
        reward = new LadderReward(Arrays.asList("꽝", "5000", "꽝"));
    }

    @Test
    void ladder_exception() {
        ladderLines = new ArrayList<>(Arrays.asList(new LadderLine(Arrays.asList(new Point(0, RIGHT), new Point(1, LEFT)))));

        assertThatThrownBy(() -> new Ladder(ladderLines, reward))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_LINE_SIZE.getErrorMessage());
    }

    @Test
    void getReward() {
        ladderLines = new ArrayList<>(Arrays.asList(
                new LadderLine(Arrays.asList(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, DOWN))),
                new LadderLine(Arrays.asList(new Point(0, DOWN), new Point(1, LEFT), new Point(2, RIGHT)))));
        Ladder ladder = new Ladder(ladderLines, reward);

        String actual = ladder.getReward(1);

        assertThat(actual).isEqualTo("꽝");
    }
}

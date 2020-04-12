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
    private List<LadderLine> ladderLines;

    @Test
    void ladder_exception() {
        ladderLines = new ArrayList<>(Arrays.asList(new LadderLine(Arrays.asList(new Point(0, RIGHT), new Point(1, LEFT)))));

        List<String> userNames = Arrays.asList("seul", "pobi");
        int height = 5;

        assertThatThrownBy(() -> new Ladder(userNames, height, Arrays.asList("꽝", "5000", "꽝")))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_LINE_SIZE.getErrorMessage());
    }

    @Test
    void getReward() {
        int height = 5;
        List<String> userNames = Arrays.asList("seul", "pobi", "sseul");
        List<String> rewardValue = Arrays.asList("꽝", "5000", "꽝");
        Ladder ladder = new Ladder(userNames, height, rewardValue);

        String actual = ladder.getReward(1);

        assertThat(rewardValue).contains(actual);
    }
}

package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static ladder.domain.type.DirectionType.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<LadderLine> ladderLines = Arrays.asList(
                new LadderLine(Arrays.asList(new Point(0, RIGHT), new Point(1, LEFT), new Point(1, DOWN))),
                new LadderLine(Arrays.asList(new Point(0, DOWN), new Point(1, RIGHT), new Point(1, LEFT))));

        ladder = new Ladder(ladderLines, new LadderReward(Arrays.asList("100", "꽝", "200")));
    }

    @Test
    void users() {
        new Users(Arrays.asList("pobi", "honux", "crong"), ladder);
    }

    @Test
    void users_exception() {
        assertThatThrownBy(() -> new Users(Arrays.asList("pobi1234", "honux", "crong"), ladder))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_NAME_SIZE.getErrorMessage());
    }
}

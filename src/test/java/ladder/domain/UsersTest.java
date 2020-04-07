package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        int userCount = 4;
        ladder = new Ladder(userCount, 5, new LadderReward("100,꽝,200,300", userCount));
    }

    @Test
    void users() {
        new Users(Arrays.asList("pobi", "honux", "crong", "jk"), ladder);
    }

    @Test
    void users_exception() {
        assertThatThrownBy(() -> new Users(Arrays.asList("pobi1234", "honux", "crong", "jk"), ladder))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_NAME_SIZE.getErrorMessage());
    }
}

package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UsersTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        int height = 5;
        List<String> userNames = Arrays.asList("seul", "pobi", "sseul");
        List<String> rewardValues = Arrays.asList("100", "꽝", "200");

        ladder = new Ladder(userNames, height, rewardValues);
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

package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    private Ladder ladder;
    private List<User> users;
    private List<String> userNames;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(4, 5, Arrays.asList("1000", "꽝", "2000", "꽝"));
        userNames = Arrays.asList("pobi","honux","crong","jk");
        users = User.listOf(userNames, ladder);
    }

    @Test
    void listOf() {
        assertThat(users).hasSize(4);
        assertThat(users.get(0).getName()).isEqualTo(userNames.get(0));
        assertThat(users.get(1).getName()).isEqualTo(userNames.get(1));
        assertThat(users.get(2).getName()).isEqualTo(userNames.get(2));
        assertThat(users.get(3).getName()).isEqualTo(userNames.get(3));
    }

    @Test
    void listOf_EXCEPTION() {
        assertThatThrownBy(() -> User.listOf(Arrays.asList("pobi","honux", "crong12", "jk"), ladder))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_NAME_SIZE.getErrorMessage());
    }

    @Test
    void equalsUserName() {
        assertThat(users.get(0).equalsUserName(userNames.get(0))).isTrue();
        assertThat(users.get(1).equalsUserName(userNames.get(1))).isTrue();
        assertThat(users.get(2).equalsUserName(userNames.get(2))).isTrue();
        assertThat(users.get(3).equalsUserName(userNames.get(3))).isTrue();
    }
}

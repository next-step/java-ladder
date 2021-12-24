package nextstep.ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    public static final Ladder LADDER = Ladder.initate(4, 5);

    private static final int VALID_HEIGHT_OF_LADDER = 5;

    @Test
    void initTest() {
        // then
        assertThat(Ladder.initate(UsersTest.FOUR_USERS.size(), VALID_HEIGHT_OF_LADDER)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void checkExceptionForInvalidUserSizeTest(int invalidUserSize) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Ladder.initate(invalidUserSize, VALID_HEIGHT_OF_LADDER)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void checkExceptionForInvalidHeightTest(int invalidHeight) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Ladder.initate(UsersTest.FOUR_USERS.size(), invalidHeight)
        );
    }

    @Test
    void getLaddersTest() {
        // given
        Ladder ladder = Ladder.initate(UsersTest.FOUR_USERS.size(), VALID_HEIGHT_OF_LADDER);
        // when & then
        assertThat(ladder.getLadderLines()).hasSize(VALID_HEIGHT_OF_LADDER);
    }
}

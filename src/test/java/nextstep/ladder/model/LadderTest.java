package nextstep.ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {
    private static final int HEIGHT_OF_LADDER = 5;
    private static final int USER_SIZE = 4;
    public static final Ladder LADDER = Ladder.initate(USER_SIZE, HEIGHT_OF_LADDER);
    private static final int INITIATIVE_INDEX = 0;

    @Test
    void initTest() {
        // then
        assertThat(LADDER).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void checkExceptionForInvalidUserSizeTest(int invalidUserSize) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Ladder.initate(invalidUserSize, HEIGHT_OF_LADDER)
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
        // when & then
        assertThat(LADDER.getLadderLines()).hasSize(HEIGHT_OF_LADDER);
    }

    @Test
    void heightTest() {
        // when & then
        assertThat(LADDER.height()).isEqualTo(HEIGHT_OF_LADDER);
    }

    @Test
    void moveTest() {
        // when
        int index = LADDER.move(INITIATIVE_INDEX);
        // then
        assertAll(
                () -> assertThat(index).isGreaterThanOrEqualTo(INITIATIVE_INDEX),
                () -> assertThat(index).isLessThanOrEqualTo(LADDER.height())
        );
    }
}

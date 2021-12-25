package nextstep.ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderLineTest {
    private static final int VALID_USER_SIZE = 5;
    private static final LadderLine LADDER_LINE = LadderLine.init(VALID_USER_SIZE);

    @Test
    void initTest() {
        // then
        assertThat(LADDER_LINE).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, Integer.MIN_VALUE})
    void checkExceptionForInvalidUserSizeTest(int userSize) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> LadderLine.init(userSize)
        );
    }

    @Test
    void getPointsTest() {
        // when & then
        assertThat(LADDER_LINE.getPoints()).hasSize(VALID_USER_SIZE);
    }

    @Test
    void moveTest() {
        // when & then
        assertThat(LADDER_LINE.move(0)).isIn(0, 1);
    }
}

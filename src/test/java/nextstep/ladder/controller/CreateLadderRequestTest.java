package nextstep.ladder.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CreateLadderRequestTest {
    public static final CreateLadderRequest CREATE_LADDER_REQUEST = CreateLadderRequest.of(4, 5);
    private static final List<String> USER_NAMES = Arrays.asList("pobi", "honux", "crong", "jk");

    @Test
    void ofTest() {
        // when
        CreateLadderRequest request = CreateLadderRequest.of(USER_NAMES.size(), 5);
        // then
        assertThat(request).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, Integer.MIN_VALUE})
    void checkExceptionForInvalidUserNamesTest(int userSize) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> CreateLadderRequest.of(userSize, 5)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void checkExceptionForInvalidHeightOfLadderTest(int heightOfLadder) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> CreateLadderRequest.of(USER_NAMES.size(), heightOfLadder)
        );
    }

    @Test
    void getUserSizeTest() {
        // given
        CreateLadderRequest request = CreateLadderRequest.of(USER_NAMES.size(), 5);
        // when
        int userSize = request.getUserSize();
        // then
        assertThat(userSize).isEqualTo(USER_NAMES.size());
    }

    @Test
    void getHeightOfLadderTest() {
        // given
        int heightOfLadder = 5;
        CreateLadderRequest request = CreateLadderRequest.of(USER_NAMES.size(), heightOfLadder);
        // when & then
        assertThat(request.getHeightOfLadder()).isEqualTo(heightOfLadder);
    }
}

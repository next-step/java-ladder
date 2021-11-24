package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("이름의 길이가 1이상 5이하가 아니라면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] name: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"아주아아주아주긴이름", "조으금긴이름"})
    void create_illegalLength_thrownException(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(name))
                .withMessage(Name.ILLEGAL_LENGTH_ERROR_MESSAGE);
    }

}

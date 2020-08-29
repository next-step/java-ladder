package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    @DisplayName("이름을 입력하지 않은 경우 Name 생성 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void from_name_is_null_empty(String input) {
        String expectedExceptionMessage = LadderExceptionMessage.PARTICIPANT_NAME_NEED_MORE_THAN_ONE;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.from((input)))
                .withMessage(expectedExceptionMessage);
    }

    @DisplayName("5자 이상 이름 입력 시 Name 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"dundun", "안녕하세요빰빰"})
    void from_name_too_long(String input) {
        String expectedExceptionMessage = LadderExceptionMessage.PARTICIPANT_NAME_TOO_LONG;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.from(input))
                .withMessage(expectedExceptionMessage);
    }
}

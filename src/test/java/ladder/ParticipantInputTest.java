package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ParticipantInputTest {

    @ParameterizedTest(name = "참여자의 이름이 null 일경우 에러를 발생시킨다.")
    @NullAndEmptySource
    void emptyInputTest(String source) {
        assertThatThrownBy(() -> new ParticipantInput(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 필수 입력값입니다.");

    }
}

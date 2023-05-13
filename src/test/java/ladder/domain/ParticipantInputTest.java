package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import ladder.domain.ParticipantInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("참가자, 또는 비어있지 않은 문자열 입력시 정상 객체가 생성된다")
    void objectCreateTest() {
        assertDoesNotThrow(() -> new ParticipantInput("test,name"));
    }
}

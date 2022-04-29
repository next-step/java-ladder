package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("참여자")
class ParticipantTest {

    @Test
    @DisplayName("5자 이하의 문자로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Participant.from("name"));
    }

    @ParameterizedTest(name = "[{index}] {0} 값으로 이름 생성 불가")
    @DisplayName("이름의 문자열은 필수")
    @NullAndEmptySource
    void instance_nullOrEmpty_thrownIllegalArgumentException(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Participant.from(name));
    }

    @Test
    @DisplayName("5자 이하의 문자열이어야 함")
    void instance_lengthOverThanFive_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Participant.from("a".repeat(6)));
    }

    @Test
    @DisplayName("주어진 이름 그대로 반환")
    void value() {
        //given
        String name = "a";
        //when, then
        assertThat(Participant.from(name).value()).isEqualTo(name);
    }
}

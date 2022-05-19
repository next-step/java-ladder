package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {
    @DisplayName("참여자 이름을 인자로 받는 정적 팩토리 메서드 테스트")
    @Test
    void from() {
        assertThat(Participant.from("pobi")).isNotNull();
    }

    @DisplayName("생성하려는 참여자의 이름이 최대 길이를 초과하는 경우 예외 발생 검증")
    @Test
    void exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> Participant.from("abcdef"));
    }
}
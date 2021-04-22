package ladder.domain.participant;

import ladder.exception.InvalidNameSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @DisplayName("Participant 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        String name = "wojir";

        // when
        Participant participant = Participant.of(name);

        // then
        assertThat(participant).isNotNull();
    }

    @DisplayName("Participant 인스턴스가 5글자 초과의 값 주입시 예외처리 여부 테스트")
    @Test
    void 검증_5글자_초과() {
        // given
        String name = "woojae";

        // when
        assertThatThrownBy(()-> Participant.of(name))
                .isInstanceOf(InvalidNameSizeException.class)
                .hasMessage("woojae와 같이 5글자가 초과된 이름은 사용할 수 없습니다.");
    }
}
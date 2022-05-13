package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ParticipantTest {

    @Test
    @DisplayName("참가자 객체를 생성합니다.")
    void createParticipantObject() {
        // given
        String name = "pobi";

        // when
        Participant participant = new Participant(name);

        // then
        assertThat(participant.toString()).isEqualTo(name);
    }

    @Test
    @DisplayName("참가자 이름의 길이가 5자를 초과하는 경우 예외처리를 합니다.")
    void exceptionParticipantNameLengthOverStandard() {
        // given
        String name = "pobipobi";

        // when & then
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "참가자의 이름이 null이거나 empty인 경우 예외처리를 합니다.")
    @NullAndEmptySource
    void exceptionParticipantIsNullOrEmpty(String name) {
      // when & then
      assertThatThrownBy(() -> new Participant(name))
              .isInstanceOf(IllegalArgumentException.class);
    }
}

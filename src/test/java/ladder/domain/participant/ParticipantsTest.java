package ladder.domain.participant;

import ladder.exception.ParticipantListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

    @DisplayName("Participants 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        String[] names = "a,b,c".split(",");

        // when
        Participants participants = Participants.of(names);

        // then
        assertThat(participants).isNotNull();
    }

    @DisplayName("Participants 인스턴스에 NULL 입력시 예외처리 여부 테스트")
    @Test
    void 검증_NULL() {
        // given
        List<Participant> participantList = null;

        // when
        assertThatThrownBy(() -> Participants.of(participantList))
                .isInstanceOf(ParticipantListNullPointerException.class)
                .hasMessage("List<Participant>가 null 입니다.");

    }
}
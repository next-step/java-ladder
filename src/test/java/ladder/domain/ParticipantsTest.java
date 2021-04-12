package ladder.domain;

import ladder.exception.ParticipantListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

    @DisplayName("Participants 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String names = "pobi,honux,crong,jk";

        // when
        Participants participants = Participants.of(names);

        // then
        assertThat(participants).isNotNull();
    }

    @DisplayName("Participants 인스턴스 생성 여부 테스트")
    @Test
    void 검증() {
        // given
        List<Participant> participantList = null;

        // when and then
        assertThatThrownBy(() -> Participants.of(participantList))
                .isInstanceOf(ParticipantListNullPointerException.class)
                .hasMessage("List<Participant>가 null 입니다.");

    }
}
package nextstep.ladder.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {

    @DisplayName("참여자 인덱스 검색 메서드 호출 시 참여자의 위치를 잘 반환하는지")
    @Test
    void findParticipantIndexTest() {
        Participants participants = new Participants(List.of(new Participant("honux"), new Participant("pobi")));
        assertThat(participants.findParticipantIndex("honux")).isEqualTo(0);
    }

    @DisplayName("참여자 인덱스 검색 메서드 호출 시 참여자 이름이 없는 경우 예외가 잘 발생하는지")
    @Test
    void findParticipantIndex_withInvalidName() {
        Participants participants = new Participants(List.of(new Participant("honux"), new Participant("pobi")));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> participants.findParticipantIndex("crong"));
    }
}

package ladder.domain.participant;

import ladder.exception.ParticipantListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        // when and then
        assertThatThrownBy(() -> Participants.of(participantList))
                .isInstanceOf(ParticipantListNullPointerException.class)
                .hasMessage("List<Participant>가 null 입니다.");

    }

    @DisplayName("Participants 인스턴스가 소유한 값의 크기 반환 테스트")
    @Test
    void 반환_사이즈() {
        // given
        String[] names = "a,b,c".split(",");

        // when
        Participants participants = Participants.of(names);
        int actual = participants.countOfParticipants();

        // then
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("Participants 인스턴스가 소유한 참가자 이름 반환 테스트")
    @Test
    void 반환_참가자_이름들() {
        // given
        List<String> expected = Arrays.asList("a", "b", "c");
        List<Participant> participantList = expected.stream()
                .map(Participant::of)
                .collect(Collectors.toList());


        // when
        Participants participants = Participants.of(participantList);
        List<String> actual = participants.values();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
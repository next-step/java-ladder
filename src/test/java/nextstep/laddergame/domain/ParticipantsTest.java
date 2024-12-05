package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @DisplayName("Participant 객체들을 포함하는 일급 컬렉션 Participants 객체를 생성한다.")
    @Test
    void values() {
        Participants given = new Participants(List.of("moon", "yoon", "ji"));

        assertThat(given.values()).containsExactly(
                new Participant("moon", 0),
                new Participant("yoon", 1),
                new Participant("ji", 2));
    }

    @DisplayName("전달받은 name에 매핑되는 Participant 객체를 반환한다.")
    @Test
    void from() {
        Participants participants = new Participants(List.of("moon", "yoon", "ji"));

        Participant actual = participants.getParticipantBy("moon");

        assertThat(actual).isEqualTo(new Participant("moon", 0));
    }

}

package ladder.domain;

import ladder.domain.participant.Participants;
import ladder.helper.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Particpant 들을 List로 갖고있는 일급 컬렉션 클래스")
public class ParticipantsTest {
    @DisplayName("참가자들을 이름과 사다리 크기 정보(LadderSize)를 가지고 생성한다.")
    @Test
    void create() {
        assertThat(new Participants(Fixture.participantNames(), Fixture.ladderSize())).isNotNull();
    }
}

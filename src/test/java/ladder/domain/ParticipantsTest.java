package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {
    @Test
    @DisplayName("참가자가 2명 미만일경우 에러발생")
    void 참가자_목록_실패() {
        assertThatIllegalArgumentException().isThrownBy(()
                -> new Participants(List.of(new Participant("aaaaa"))));
    }

    @Test
    @DisplayName("참가자 수 확인")
    void 참가자_이름_성공() {
        List<Participant> testParticipants = List.of(new Participant("aaaaa"), new Participant("bbbbb"));
        assertThat(new Participants(testParticipants).countOfMember()).isEqualTo(2);
    }
}
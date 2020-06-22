package ladder.domain.participants;

import ladder.domain.participants.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class ParticipantsTest {
    String nameOfPerson = "eunji, pobi, jerry";

    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThatCode(() -> Participants.valueOf(nameOfPerson)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참가자 수를 반환")
    void size() {
        Participants participants = Participants.valueOf(nameOfPerson);
        int countOfPerson = participants.size();

        assertThat(countOfPerson).isEqualTo(3);
    }


}

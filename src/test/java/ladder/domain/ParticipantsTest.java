package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class ParticipantsTest {
    String nameOfPerson = "eunji, pobi, jerry";

    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThatCode(() -> Participants.create(nameOfPerson)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참가자 수를 반환")
    void tellCountOfPerson() {
        Participants participants = Participants.create(nameOfPerson);
        int countOfPerson = participants.tellCountOfPerson();

        assertThat(countOfPerson).isEqualTo(3);
    }
}

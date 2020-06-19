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
        assertThatCode(() -> Participants.valueOf(nameOfPerson)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참가자 수를 반환")
    void size() {
        Participants participants = Participants.valueOf(nameOfPerson);
        int countOfPerson = participants.size();

        assertThat(countOfPerson).isEqualTo(3);
    }

    @Test
    @DisplayName("사다리 실행 테스트")
    void runLadder() {
        Ladder ladder = Ladder.valueOf(3, 2);
        Results results = Results.valueOf("꽝, 당첨", 2);
        Participants participants = Participants.valueOf("ej, pobi");

        assertThatCode(() -> participants.runLadder(ladder, results)).doesNotThrowAnyException();

    }
}

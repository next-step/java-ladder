package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class ParticipantsTest {
    String nameOfPerson = "eunji, pobi, jerry";

    @Test
    void 생성_테스트() {
        assertThatCode(() -> Participants.create(nameOfPerson)).doesNotThrowAnyException();
    }

}

package ladder.domain;

import ladder.exception.InvalidNameOfParticipant;
import ladder.exception.InvalidNumberOfParticipants;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {
    @Test
    void 참가자_수가_0인_경우_테스트() {
        assertThatThrownBy(() -> new Participants(""))
                .isInstanceOf(InvalidNumberOfParticipants.class);
        assertThatThrownBy(() -> new Participants(","))
                .isInstanceOf(InvalidNumberOfParticipants.class);
    }

    @Test
    void 참가자_수가_1인_경우_테스트() {
        assertThatThrownBy(() -> new Participants("abc"))
                .isInstanceOf(InvalidNumberOfParticipants.class);
        assertThatThrownBy(() -> new Participants("a,"))
                .isInstanceOf(InvalidNumberOfParticipants.class);

    }

    @Test
    void 참가자_이름이_0자인_경우_테스트() {
        assertThatThrownBy(() -> new Participants(",a"))
                .isInstanceOf(InvalidNameOfParticipant.class);
    }

    @Test
    void 참가자_이름이_5자_이상인_경우_테스트() {
        assertThatThrownBy(() -> new Participants("a,abc,bcdefg"))
                .isInstanceOf(InvalidNameOfParticipant.class);
    }
}
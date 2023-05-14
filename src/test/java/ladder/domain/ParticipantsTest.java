package ladder.domain;

import static ladder.domain.Participants.PARTICIPANT_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    private static final String DUMMY_PARTICIPANTS_CHUNK = "pobi,honux,crong,jk";

    @Test
    @DisplayName("참여자 배열을 입력했을 경우 정상 객체를 생성한다.")
    void objCreateTest() {
        assertDoesNotThrow(() -> new Participants(DUMMY_PARTICIPANTS_CHUNK));
    }

    @Test
    @DisplayName("입력된 참가자 숫자를 리턴한다.")
    void sizeTest() {
        assertThat(new Participants(DUMMY_PARTICIPANTS_CHUNK).countOfPerson())
                .isEqualTo(DUMMY_PARTICIPANTS_CHUNK.split(PARTICIPANT_SEPARATOR).length);
    }

}

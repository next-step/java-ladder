package ladder.domain;

import static ladder.domain.Participants.PARTICIPANT_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
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

    @Test
    @DisplayName("참가인원이 없는 경우 익셉션을 발생한다.")
    void noParticipantsTest() {
        assertThatThrownBy(() -> new Participants(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1명이상의 참가인원이 있어야합니다.");
    }
}

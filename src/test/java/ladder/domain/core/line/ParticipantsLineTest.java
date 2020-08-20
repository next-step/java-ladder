package ladder.domain.core.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsLineTest {

    @DisplayName("참가자들는 쉼표를 기준으로 공백이나 null일수 없음")
    @Test
    void blankParticipantsTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> ParticipantsLine.of(null))
            .withMessage(BaseName.ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> ParticipantsLine.of(" "))
            .withMessage(BaseName.ERROR_MESSAGE_REQUIRED_NAME);
    }

    @DisplayName("잘못된 참가자 이름이 있는 경우 예외 처리")
    @Test
    void suitableNameCheckTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> ParticipantsLine.of("123"))
            .withMessage(Participant.ERROR_MESSAGE_SUITABLE_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> ParticipantsLine.of("a12345"))
            .withMessage(Participant.ERROR_MESSAGE_SUITABLE_NAME);
    }

    @DisplayName("참가자들는 쉼표를 기준으로 구분함")
    @Test
    void participantsTest() {
        assertThat(ParticipantsLine.of("pobi,honux,crong,jk").getNumberOfParticipants()).isEqualTo(4);
    }

    @DisplayName("index 혹은 이름 기준으로 값 확인")
    @Test
    void indexAndResultTest() {
        ParticipantsLine participantsLine = ParticipantsLine.of("pobi,honux,crong,jk");
        assertThat(participantsLine.indexOf("jk")).isEqualTo(3);
        assertThat(participantsLine.getResult(3)).isEqualTo("jk");
    }

    @DisplayName("화면 표시할때 6자리 수 만큼 표시 되는 확인")
    @Test
    void displayTest() {
        assertThat(ParticipantsLine.of("pobi,honux,crong,jk").toDisplayResult().toDisplay())
            .isEqualTo("  pobi honux crong    jk");
    }
}

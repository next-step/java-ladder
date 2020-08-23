package ladder.domain.core.line.name;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NamesLineTest {

    @DisplayName("쉼표를 기준으로 공백이나 null일수 없음")
    @Test
    void blankNamesTest() {
        assertThatIllegalArgumentException(() -> ParticipantsLine.of(null), Name.ERROR_MESSAGE_REQUIRED_NAME);
        assertThatIllegalArgumentException(() -> ParticipantsLine.of(" "), Name.ERROR_MESSAGE_REQUIRED_NAME);
        assertThatIllegalArgumentException(() -> LadderResultLine.of(null), Name.ERROR_MESSAGE_REQUIRED_NAME);
        assertThatIllegalArgumentException(() -> LadderResultLine.of(" "), Name.ERROR_MESSAGE_REQUIRED_NAME);

    }

    private void assertThatIllegalArgumentException(ThrowableAssert.ThrowingCallable tc, String errorMessageRequiredName) {
        Assertions.assertThatIllegalArgumentException()
                  .isThrownBy(tc)
                  .withMessage(errorMessageRequiredName);
    }

    @DisplayName("잘못된 이름이 있는 경우 예외 처리")
    @Test
    void suitableNameCheckTest() {
        assertThatIllegalArgumentException(() -> ParticipantsLine.of("123"), Name.ERROR_MESSAGE_SUITABLE_NAME);
        assertThatIllegalArgumentException(() -> ParticipantsLine.of("a12345"), Name.ERROR_MESSAGE_SUITABLE_NAME);
        assertThatIllegalArgumentException(() -> LadderResultLine.of("a12345"), Name.ERROR_MESSAGE_MAX_LEN_NAME);
    }

    @DisplayName("참가자들는 쉼표를 기준으로 구분함")
    @Test
    void participantsTest() {
        assertThat(ParticipantsLine.of("pobi,honux,crong,jk").getWidth()).isEqualTo(4);
    }

    @DisplayName("index 혹은 이름 기준으로 값 확인")
    @Test
    void indexAndResultTest() {
        ParticipantsLine participantsLine = ParticipantsLine.of("pobi,honux,crong,jk");
        assertThat(participantsLine.indexOf("jk")).isEqualTo(3);
        assertThat(participantsLine.getResult(3)).isEqualTo("jk");

        LadderResultLine ladderResultLine = LadderResultLine.of("꽝,1000,2000,꽝");
        assertThat(ladderResultLine.getResult(3)).isEqualTo("꽝");
    }

    @DisplayName("화면 표시할때 6자리 수 만큼 표시 되는 확인")
    @Test
    void displayTest() {
        assertThat(ParticipantsLine.of("pobi,honux,crong,jk").toDisplayResult().toDisplay())
            .isEqualTo("  pobi honux crong    jk");

        assertThat(LadderResultLine.of("꽝,1000,2000,꽝").toDisplayResult().toDisplay())
            .isEqualTo("     꽝  1000  2000     꽝");
    }
}

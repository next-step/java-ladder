package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    public static final Game GAME = new Game(LadderTest.LADDER, ParticipantsTest.PARTICIPANTS, ResultsTest.RESULTS);

    @Test
    @DisplayName("개별 참가자 결과 조회 테스트")
    public void getIndividualResultTest() {
        assertThat(GAME.getIndividualResult(ParticipantTest.PARTICIPANT_A)).isEqualTo("3등");
        assertThat(GAME.getIndividualResult(ParticipantTest.PARTICIPANT_B)).isEqualTo("1등");
        assertThat(GAME.getIndividualResult(ParticipantTest.PARTICIPANT_C)).isEqualTo("꽝");
        assertThat(GAME.getIndividualResult(ParticipantTest.PARTICIPANT_D)).isEqualTo("2등");
    }
}

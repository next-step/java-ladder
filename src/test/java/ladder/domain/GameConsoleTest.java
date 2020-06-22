package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.participants.Participants;
import ladder.domain.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class GameConsoleTest {

    @Test
    @DisplayName("생성 테스트")
    void valueOf() {
        assertThatCode(() -> GameConsole.valueOf(Participants.valueOf("ej"),
                Ladder.valueOf(3, 1)));
    }

    @Test
    @DisplayName("사다리 실행 테스트")
    void runLadder() {
        Participants participants = Participants.valueOf("ej, pobi");
        Ladder ladder = Ladder.valueOf(3, 2);
        Results results = Results.valueOf("꽝, 당첨", 2);

        GameConsole gameConsole = GameConsole.valueOf(participants, ladder);
        assertThatCode(() -> gameConsole.runLadder(results)).doesNotThrowAnyException();

    }
}

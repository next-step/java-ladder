package ladder.game;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.RandomMove;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    private LadderGame ladderGame;
    private MoveStrategy moveStrategy = new RandomMove();

    @BeforeEach
    void setUp() {
        String participants = "pobi, honux, crong, jk";
        String inputResults = "꽝, 꽝, 천원, 만원";
        int ladderHeight = 5;
        ladderGame = new LadderGame(participants, ladderHeight, moveStrategy, inputResults);
    }

    @Test
    void getParticipants() {
        assertThat(ladderGame.getParticipants().toStrings())
                .containsExactlyInAnyOrderElementsOf
                        (Arrays.asList("pobi", "honux", "crong", "jk"));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "혼자인아이:4:꽝",
            "이름이 긴 아이, 이름이 긴 아이2:5:꽝, 꽝",
            "사다리, 높이가, 음수:-1:꽝, 꽝, 1000원",
            "한명, 두명, 세명, 네명:5:결과값이 긴 경우, 1000원, 10000원, 100000원",
            "한명, 두명, 세명, 네명:5:사다리, 개수가, 맞지, 않는, 경우"
    }, delimiter = ':')
    @DisplayName("입력 시 예외상황 발생")
    void participantNameException(String participantsName, int ladderHeight, String inputResult) {
        assertThrows(IllegalArgumentException.class,
                () -> new LadderGame(participantsName, ladderHeight, moveStrategy, inputResult));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "pobi,honux:꽝2,꽝1",
            "crong,jk:만원,천원"
    }, delimiter = ':')
    @DisplayName("사용자별 결과 가지고오는지 확인")
    void getResult(String participant, String result) {
        String participants = "pobi, honux, crong, jk";
        String inputResults = "꽝1, 꽝2, 천원, 만원";
        int ladderHeight = 5;
        ladderGame = new LadderGame(participants, ladderHeight, new DefaultMove(), inputResults);
        assertThat(ladderGame.checkPrizesByParticipant(participant.split(",")).values().values())
                .containsExactly(result.split(","));
    }

    @ParameterizedTest
    @ValueSource(strings = "예외, 발생, 확인")
    @DisplayName("찾는 사용자가 없을 때 예외 발생")
    void getResultExceptionTest(String participant) {
        assertThrows(IllegalArgumentException.class, () -> ladderGame.checkPrizesByParticipant(participant));
    }
}
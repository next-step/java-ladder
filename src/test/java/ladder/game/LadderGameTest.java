package ladder.game;

import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.RandomConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    private LadderGame ladderGame;
    private ConnectionStrategy connectionStrategy = new RandomConnection();

    @BeforeEach
    void setUp() {
        String participants = "pobi, honux, crong, jk";
        String inputResults = "꽝, 꽝, 천원, 만원";
        int ladderHeight = 5;
        ladderGame = new LadderGame(participants, ladderHeight, connectionStrategy, inputResults);
    }

    @Test
    void getParticipants() {
        assertThat(ladderGame.getParticipants().getNames())
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
                () -> new LadderGame(participantsName, ladderHeight, connectionStrategy, inputResult));
    }

    @Test
    void getLadder() {
        assertThat(ladderGame.getLadder().getLadderHeight()).isEqualTo(5);
    }
}
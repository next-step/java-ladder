package ladder.game;

import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.RandomConnection;
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
    private ConnectionStrategy connectionStrategy = new RandomConnection();

    @BeforeEach
    void setUp() {
        String participants = "pobi, honux, crong, jk";
        int ladderHeight = 5;
        ladderGame = new LadderGame(participants, ladderHeight, connectionStrategy);
    }

    @Test
    void getParticipants() {
        assertThat(ladderGame.getParticipants())
                .containsExactlyInAnyOrderElementsOf
                        (Arrays.asList("pobi", "honux", "crong", "jk"));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "혼자인아이:4",
            "이름이 긴 아이, 이름이 긴 아이2:5",
            "한명, 두명, 세명:-1"
    }, delimiter = ':')
    @DisplayName("입력 시 예외상황 발생")
    void participantNameException(String participantsName, int ladderHeight) {
        assertThrows(IllegalArgumentException.class,
                () -> new LadderGame(participantsName, ladderHeight, connectionStrategy));
    }

    @Test
    void getLadder() {
        assertThat(ladderGame.getLadderHeight()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "결과값이 긴 경우, 결과값이 긴 경우, 결과값이 긴 경우, 결과값이 긴 경우",
            "사다리, 개수가, 맞지, 않는, 경우"
    })
    @DisplayName("결과 입력 시 예외 발생")
    void inputResultException(String inputResult) {
        assertThrows(IllegalArgumentException.class, () -> ladderGame.setResults(inputResult));
    }
}
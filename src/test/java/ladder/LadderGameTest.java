package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.strategy.BridgeBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    private static Ladder ladder;
    private static List<String> playersName;

    @BeforeAll
    @DisplayName("테스트 시나리오 준비--!!")
    static void prepareTestScenario() {
        List<String> predefined = Arrays.asList("0,2", "1", "0", "1", "0,2");
        BridgeBuilder bridgeBuilder = new BridgeBuilder(predefined);

        ladder = new Ladder(5, 4, bridgeBuilder);
        ladder.build();

        playersName = Arrays.asList("pobi", "honux", "crong", "jk");
    }

    @Test
    @DisplayName("이동 후 플레이어 위치를 확인한다.")
    void movePlayersTest() {
        LadderGame ladderGame = new LadderGame(playersName, ladder);

        ladderGame.start();
        Player pobi = ladderGame.findPlayerByName("pobi");
        Player honux = ladderGame.findPlayerByName("honux");
        Player crong = ladderGame.findPlayerByName("crong");
        Player jk = ladderGame.findPlayerByName("jk");

        assertThat(pobi.isPlayerInPosition(new Point(0))).isEqualTo(true);
        assertThat(honux.isPlayerInPosition(new Point(3))).isEqualTo(true);
        assertThat(crong.isPlayerInPosition(new Point(2))).isEqualTo(true);
        assertThat(jk.isPlayerInPosition(new Point(1))).isEqualTo(true);
    }

    @Test
    @DisplayName("플레이어 이름을 담고, 이름을 출력한다.")
    void createPlayersAndPrintPlayerNames() {
        LadderGame ladderGame = new LadderGame(playersName, ladder);

        List<String> expectedNames = ladderGame.getAllPlayerNames();

        assertThat(playersName).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("플레이어 목록에서 이름으로 플레이어를 찾을 수 있다.")
    void findPlayerTestByName() {
        LadderGame ladderGame = new LadderGame(playersName, ladder);

        assertThat(ladderGame.findPlayerByName("pobi")).isEqualTo(new Player("pobi", new Point(0)));
    }
}

package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    @Test
    void toString_2개이상() {
        List<PlayerWinnings> playerWinnings = List.of(
                new PlayerWinnings(Player.of("test"), new WinningItem("꽝"))
                , new PlayerWinnings(Player.of("test2"), new WinningItem("5000"))
                , new PlayerWinnings(Player.of("test3"), new WinningItem("6000")));
        LadderGameResult result = new LadderGameResult(playerWinnings);

        String resultString = result.toString();

        assertThat(resultString).isEqualTo("test: 꽝\ntest2: 5000\ntest3: 6000");
    }
}

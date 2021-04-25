package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.laddergame.domain.player.Players;

import java.util.Arrays;
import java.util.List;

public class LadderWinningTest {
    private Ladder ladder;
    private Players players;

    @BeforeEach
    void setUp() {
        Size size = Size.of(5, 6);
        List<String> nameList = Arrays.asList("이름1", "이름2", "이름3", "이름4", "이름5", "이름6");
        ladder = Ladder.of(size, () -> true);
        players = Players.of(nameList);
    }


    @Test
    void 플레이어들의사다리타기결과를생성() {
    }
}

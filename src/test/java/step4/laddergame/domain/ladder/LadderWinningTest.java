package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.laddergame.domain.player.Players;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderWinningTest {
    private Players players;
    private LadderWinning winning = new LadderWinning();

    @BeforeEach
    void setUp() {
        Size size = Size.of(5, 6);
        List<String> nameList = Arrays.asList("이름1", "이름2", "이름3", "이름4", "이름5", "이름6");
        players = Players.of(nameList);
    }

    @Test
    void 플레이어전체결과매치() {
        List<Result> resultList = Arrays.asList(Result.of("결과1"), Result.of("결과2"), Result.of("결과3"), Result.of("결과4"), Result.of("결과5"), Result.of("결과6"));
        winning = LadderWinning.of(players, resultList);
        assertThat(winning.findOne("이름3")).isEqualTo(resultList.get(3-1));
    }
}

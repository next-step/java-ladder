package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.laddergame.domain.player.Players;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderWinningTest {
    private Players players;
    private List<Result> resultList;
    private LadderWinning winning = new LadderWinning();

    @BeforeEach
    void setUp() {
        List<String> nameList = Arrays.asList("이름1", "이름2", "이름3", "이름4", "이름5", "이름6");
        resultList = Arrays.asList(Result.of("결과1"), Result.of("결과2"), Result.of("결과3"), Result.of("결과4"), Result.of("결과5"), Result.of("결과6"));
        players = Players.of(nameList);
    }

    @Test
    void 플레이어전체결과매치() {
        winning = LadderWinning.of(players, resultList);
        assertThat(winning.findOne("이름3")).isEqualTo(resultList.get(3-1));
    }

    @Test
    void 잘못된이름매치() {
        winning = LadderWinning.of(players, resultList);
        assertThatThrownBy(() -> {
            assertThat(winning.findOne("잘못이름"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

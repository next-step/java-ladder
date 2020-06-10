package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    private LadderGame ladderGame;
    private Ladder ladder;
    private static final int countOfPerson = 2;

    @BeforeEach
    void setup() {
        Players players = new Players(new String[]{"a","b"});
        ResultGoods resultGoods = new ResultGoods(new String[]{"꽝", "2000"});
        ladderGame = new LadderGame(players, resultGoods);

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(false, true)));
        lines.add(new Line(Arrays.asList(false, false)));
        lines.add(new Line(Arrays.asList(false, true)));
        ladder = new Ladder(lines);
    }

    @Test
    @DisplayName("결과가 제대로 저장되는지 확인")
    void start() {
        List<ResultOfPlayer> resultOfPlayers = ladderGame.gameResult(ladder, countOfPerson);
        assertThat(resultOfPlayers.get(0).getResult()).isEqualTo("꽝");
        assertThat(resultOfPlayers.get(1).getResult()).isEqualTo("2000");
    }
}

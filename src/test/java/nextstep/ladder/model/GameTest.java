package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(true, false, true)));
        lines.add(new Line(Arrays.asList(false, true, false)));
        lines.add(new Line(Arrays.asList(true, false, true)));

        Ladder ladder = new Ladder(lines);
        Players players = new Players("Jack, Jim, Loen, Su");
        GamePrize gamePrize = new GamePrize("1000, 꽝, 2000, 메로나열개");
        GameResult gameResult = new GameResult(ladder, players.countOfPlayer());

        game = new Game(players, gamePrize, gameResult);
    }

    @DisplayName("사람,경품,결과 통합테스트")
    @Test
    void getPrizeTest() {
        assertThat(game.getPrize(0)).isEqualTo("메로나열개");
    }
}

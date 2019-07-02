package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        Players players = new Players("Jack, Jim, Loen, Su", "1000, 꽝, 2000, 메로나열개");

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(true, false, true)));
        lines.add(new Line(Arrays.asList(false, true, false)));
        lines.add(new Line(Arrays.asList(true, false, true)));
        Ladder ladder = new Ladder(lines);

        gameResult = new GameResult(players, ladder);
    }

    @DisplayName("사다리결과 0번째 사람은 3번째 결과에 도착함")
    @Test
    void getOnePostionTest() {
        assertThat(gameResult.getOnePosition(0)).isEqualTo(3);
    }

    @DisplayName("사람,경품,결과 통합테스트")
    @Test
    void getPrizeTest() {
        assertThat(gameResult.getPrize(0)).isEqualTo("메로나열개");
    }
}

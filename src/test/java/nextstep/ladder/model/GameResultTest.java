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

    @DisplayName("출발 위치에 해당하는 결과 출력")
    @Test
    void getPrizeTest() {
        assertThat(gameResult.getPrize(0)).isEqualTo("메로나열개");
    }

    @DisplayName("이름에 해당하는 결과 출력")
    @Test
    void showPlayerResultTest() {
        assertThat(gameResult.getPrize("Jack")).isEqualTo("메로나열개");
    }

    @DisplayName("전체 결과 출력")
    @Test
    void showAllResultTest() {
        assertThat(gameResult.getFormattedResult()).isEqualTo("Jack : 메로나열개\n" +
                "Jim : 꽝\n" +
                "Loen : 2000\n" +
                "Su : 1000\n");
    }
}

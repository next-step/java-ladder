package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        Players players = new Players("Jack, Jim, Loen, Su", "패스, 패스, 패스, 메로나열개");

        List<Point> lines_1 = new ArrayList<>();
        Point point_1 = Point.first(true);
        lines_1.add(point_1);
        lines_1.add(point_1 = point_1.next(false));
        lines_1.add(point_1 = point_1.next(true));
        lines_1.add(point_1.last());

        List<Point> lines_2 = new ArrayList<>();
        Point point_2 = Point.first(false);
        lines_2.add(point_2);
        lines_2.add(point_2 = point_2.next(true));
        lines_2.add(point_2 = point_2.next(false));
        lines_2.add(point_2.last());

        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(new LadderLine(lines_1));
        ladderLines.add(new LadderLine(lines_2));
        ladderLines.add(new LadderLine(lines_1));

        Ladder ladder = new Ladder(ladderLines);

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
                "Jim : 패스\n" +
                "Loen : 패스\n" +
                "Su : 패스\n");
    }
}

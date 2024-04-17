package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("play 호출시 매개변수로 Players와 결과 목록이 주어졌을 때 사다리 게임 진행 후 결과(LadderResult) 반환")
    void play() {
        // given
        Players players = Players.from("pobi", "nimoh", "test", "race", "lotto");
        int ladderHeight = 5;

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(Line.from(players.size(), (playerCount) -> getPoints(true, false, true, false, false)));
        }

        List<String> results = List.of("꽝", "2000", "3000", "꽝", "10000");
        Ladder ladder = Ladder.from(lines);

        //when
        LadderResult ladderResult = ladder.play(players, results);

        //then
        assertThat(ladderResult.getResult("pobi")).isEqualTo("2000");
        assertThat(ladderResult.getResult("nimoh")).isEqualTo("꽝");
        assertThat(ladderResult.getResult("test")).isEqualTo("꽝");
        assertThat(ladderResult.getResult("race")).isEqualTo("3000");
        assertThat(ladderResult.getResult("lotto")).isEqualTo("10000");

    }

    private static List<Point> getPoints(boolean... pointArr) {
        List<Point> points = new ArrayList<>();
        boolean previousBoolean = false;
        for (boolean b : pointArr) {
            points.add(Point.of(previousBoolean, b));
            previousBoolean = b;
        }

        return points;
    }
}

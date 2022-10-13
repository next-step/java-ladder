package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {

    @DisplayName("플레이어가 4명이 있고 높이가 1인 사다리를 정상적으로 출력한다.")
    @Test
    void ladder() {
        List<Point> points = List.of(new Point(1, true),
                new Point(2, false),
                new Point(3, true),
                new Point(4, false));
        Line line = new Line(points);

        Ladder ladder = new Ladder(List.of(line),
                new Players(List.of(new Player("test1"),
                        new Player("test2"),
                        new Player("test3"),
                        new Player("test4"))));
        LadderResult result = new LadderResult(ladder);

        assertThat(result.lines().get(0)).isEqualTo("     |-----|     |-----|");
    }
}
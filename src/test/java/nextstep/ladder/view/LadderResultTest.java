package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @DisplayName("플레이어가 5명이 있고 높이가 1인 사다리를 정상적으로 출력한다.")
    @Test
    void printLadder() {
        List<Point> points = List.of(new Point(0, false, true),
                new Point(1, true, false),
                new Point(2, false, true),
                new Point(3, true, false),
                new Point(4, false, false));
        Line line = new Line(points);
        Players players = Players.create("test1, test2, test3, test4, test5");
        Ladder ladder = new Ladder(List.of(line), players);

        LadderResult ladderResult = new LadderResult(ladder);

        assertThat(ladderResult.getLadder()).contains("|-----|     |-----|     |");
    }
}

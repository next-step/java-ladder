package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.line.point.Point;
import nextstep.ladder.domain.line.point.Points;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.List;

public class LadderTest {

    public static Ladder getLadder() {
        // p1    p2    p3    p4
        // |-----|     |-----| line1
        // |     |-----|     | line2
        // |-----|     |     | line3

        Point l1p1 = Point.first(true);
        Point l1p2 = l1p1.next(false);
        Point l1p3 = l1p2.next(true);
        Point l1p4 = l1p3.next(false);
        Points points1 = new Points(List.of(l1p1, l1p2, l1p3, l1p4));
        Line line1 = new Line(points1);

        Point l2p1 = Point.first(false);
        Point l2p2 = l2p1.next(true);
        Point l2p3 = l2p2.next(false);
        Point l2p4 = l2p3.next(false);
        Points points2 = new Points(List.of(l2p1, l2p2, l2p3, l2p4));
        Line line2 = new Line(points2);

        Point l3p1 = Point.first(true);
        Point l3p2 = l3p1.next(false);
        Point l3p3 = l3p2.next(false);
        Point l3p4 = l3p3.next(false);
        Points points3 = new Points(List.of(l3p1, l3p2, l3p3, l3p4));
        Line line3 = new Line(points3);

        Lines lines = new Lines(List.of(line1, line2, line3));

        Player player1 = new Player("test1");
        Player player2 = new Player("test2");
        Player player3 = new Player("test3");
        Player player4 = new Player("test4");
        Players players = new Players(List.of(player1, player2, player3, player4));

        return new Ladder(players, lines);
    }

}
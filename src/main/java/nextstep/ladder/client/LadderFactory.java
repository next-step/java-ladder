package nextstep.ladder.client;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.point.RandomPointGenerator;

public class LadderFactory {

    public static Ladder createLadder(int height, List<String> names) {
        List<Player> players = names.stream()
            .map(Player::of).collect(Collectors.toList());

        List<Line> lines = Stream.generate(() -> new Line(
            LinePointFactory.of(players.size(), new RandomPointGenerator())))
            .limit(height)
            .collect(Collectors.toList());

        return new Ladder(lines, players);
    }

}

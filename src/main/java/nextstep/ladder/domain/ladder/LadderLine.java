package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.direction.Direction;
import nextstep.ladder.domain.direction.DirectionDeterminer;
import nextstep.ladder.domain.direction.RandomLineGenerator;
import nextstep.ladder.domain.player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {

    private final List<Direction> directions;

    public LadderLine(List<Direction> directions) {
        this.directions = directions;
    }

    public static LadderLine of(int groupCount) {
        DirectionDeterminer generator = new DirectionDeterminer(new RandomLineGenerator());
        List<Direction> directions = new ArrayList<>();

        for (int i = 0; i < groupCount - 1; i++) {
            directions.add(generator.next());
        }
        directions.add(generator.last());
        return new LadderLine(directions);
    }

    public void play(List<Player> players) {
        if (directions.size() != players.size()) {
            throw new IllegalArgumentException("사다리 라인 수와 참가자 리스트 수가 맞지 않습니다.");
        }
        for (Player player : players) {
            player.movePoint(directions.get(player.getPosition()));
        }
    }

    public void play(Player player) {
        player.movePoint(directions.get(player.getPosition()));
    }

    public Collection<Boolean> copy() {
        return directions.subList(0, directions.size() - 1).stream()
                .map(this::isLine)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isLine(Direction direction) {
        return direction == Direction.RIGHT_DOWN;
    }
}

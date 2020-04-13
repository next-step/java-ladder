package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.model.Position;

public class Ladder {

  private List<LadderLine> ladderLines;

  public Ladder(int height, int width) {
    ladderLines = IntStream.range(0, height)
        .mapToObj(level -> new LadderLine(width))
        .collect(Collectors.toList());
  }

  public Player ride(Player player) {
    Position finalPosition = ladderLines.stream()
        .reduce(
            player.getPosition(),
            (position, ladderLine) -> ladderLine.move(position),
            (position, position2) -> position2
        );

    return new Player(player.getName(), finalPosition);
  }

  public Players ride(Players players) {
    return Players.of(players.getPlayers()
        .stream()
        .map(this::ride)
        .collect(Collectors.toList()));
  }
}

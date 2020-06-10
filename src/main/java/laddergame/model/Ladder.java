package laddergame.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

  private final List<Line> lines;
  private final Players players;

  public Ladder(List<Line> lines, Players players) {
    this.lines = lines;
    this.players = players;
  }

  public static Ladder createByHeightAndNamesStrArr(Height height, String[] nameStrArr) {
    List<Line> lines = Stream.generate(() -> Line.createByCountOfPerson(nameStrArr.length))
        .limit(height.getValue()).collect(
            Collectors.toList());

    return new Ladder(lines, Players.createByNameStrArr(nameStrArr));
  }

  public List<Line> getLines() {
    return lines;
  }

  public Players getPlayers() {
    return players;
  }
}

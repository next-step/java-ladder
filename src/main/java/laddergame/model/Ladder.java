package laddergame.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private final List<Line> lines;
  private final Players players;

  public Ladder(List<Line> lines, Players players) {
    this.lines = lines;
    this.players = players;
  }

  public static Ladder createByHeightAndNamesStrArr(Height height, String[] nameStrArr) {
    List<Line> lines = new ArrayList<>();

    for (int i = 0; i < height.getValue(); i++) {
      lines.add(Line.createByCountOfPerson(nameStrArr.length));
    }

    return new Ladder(lines, Players.createByNameStrArr(nameStrArr));
  }

  public List<Line> getLines() {
    return lines;
  }

  public Players getPlayers() {
    return players;
  }
}

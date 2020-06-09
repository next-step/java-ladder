package laddergame.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private List<Line> lines;

  public Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public static Ladder createByHeightAndCountOfPerson(int height, int countOfPerson) {
    List<Line> lines = new ArrayList<>();

    for (int i = 0; i < height; i++) {
      lines.add(Line.createByCountOfPerson(countOfPerson));
    }

    return new Ladder(lines);
  }

  public List<Line> getLines() {
    return lines;
  }
}

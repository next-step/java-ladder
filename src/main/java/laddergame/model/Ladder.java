package laddergame.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

  private final List<Line> lines;

  public Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public static Ladder createByHeightAndCountOfPerson(
      PositiveNumber height, int countOfPerson) {

    List<Line> lines = Stream.generate(() -> Line.createByCountOfPerson(countOfPerson))
        .limit(height.getValue())
        .collect(Collectors.toList());

    return new Ladder(lines);
  }

  public int findResultPositionOf(int startPosition) {

    final int[] positionHolder = {startPosition};

    lines.forEach(line -> positionHolder[0] = line.getNextPositionAt(positionHolder[0]));

    return positionHolder[0];
  }

  public List<LineDTO> getLineDTOs() {
    return lines.stream()
        .map(LineDTO::createBy)
        .collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return "Ladder{" +
        "lines=" + lines +
        '}';
  }
}

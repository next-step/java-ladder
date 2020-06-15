package laddergame.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

  private final List<Line> lines;
  LadderPositions resultPositions;

  public Ladder(List<Line> lines) {
    this.lines = lines;
    this.resultPositions = new LadderPositions(
        Stream.iterate(0, n -> n + 1)
            .limit(lines.get(0).getPoints().size())
            .map(n -> getResultPosition(lines, new Position(new NaturalNumber(n))))
            .collect(Collectors.toList()));
  }

  public static Ladder createByHeightAndCountOfPerson(
      PositiveNumber height, PositiveNumber countOfPerson) {

    List<Line> lines = Stream.generate(() -> Line.createByCountOfPerson(countOfPerson))
        .limit(height.getValue()).collect(
            Collectors.toList());

    return new Ladder(lines);

  }

  private Position getResultPosition(List<Line> lines, Position startPosition) {
    Position position = new Position(new NaturalNumber(startPosition.getValue()));

    lines.forEach(line -> position.movePositions(position, line));

    return position;
  }

  public List<Line> getLines() {
    return Collections.unmodifiableList(lines);
  }

  public LadderPositions getResultPositions() {
    return resultPositions;
  }

}

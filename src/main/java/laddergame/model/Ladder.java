package laddergame.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

  private final List<Line> lines;

  public Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public static Ladder createByHeightAndCountOfPerson2(
      PositiveNumber height, int countOfPerson) {

    List<Line> lines = Stream.generate(() -> Line.createByCountOfPerson2(countOfPerson))
        .limit(height.getValue())
        .collect(Collectors.toList());

    return new Ladder(lines);
  }

  public int findResultPositionOf(int startPosition) {
    Position position = new Position(new NaturalNumber(startPosition));

    lines.forEach(position::movePositionBy);

    return position.getValue();
  }

  public int findResultPositionOf2(int startPosition) {

    AtomicInteger position = new AtomicInteger(startPosition);

    lines.forEach(line -> position.set(line.getNextPositionAt(position.get())));

    return position.get();
  }

  public List<Line> getLines() {
    return Collections.unmodifiableList(lines);
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

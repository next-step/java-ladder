package laddergame.model;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderResultPositions {

  private final List<Position> positions;

  public LadderResultPositions(List<Position> positions) {
    if (new HashSet<>(positions).size() != positions.size()) {
      throw new IllegalArgumentException("사다리 위치는 중복될 수 없습니다. positions : " + positions);
    }

    this.positions = positions;
  }

  public static LadderResultPositions createByLadderWithCountOfPerson(Ladder ladder,
      PositiveNumber countOfPerson) {
    return new LadderResultPositions(
        Stream.iterate(0, n -> n + 1)
            .limit(countOfPerson.getValue())
            .map(n -> getResultPosition(ladder.getLines(), new Position(new NaturalNumber(n))))
            .collect(Collectors.toList()));
  }

  private static Position getResultPosition(List<Line> lines, Position startPosition) {
    Position position = new Position(new NaturalNumber(startPosition.getValue()));

    lines.forEach(line -> position.movePositions(position, line));

    return position;
  }

  public Map<Name, Name> getMapOf(Names players, Names results) {
    return IntStream
        .range(0, positions.size())
        .boxed()
        .collect(Collectors
            .toMap(players::getNameByIndex,
                i -> results.getNameByIndex(positions.get(i).getValue()),
                (x, y) -> y,
                LinkedHashMap::new));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderResultPositions that = (LadderResultPositions) o;
    return positions.equals(that.positions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(positions);
  }

  @Override
  public String toString() {
    return "LadderPositions{" +
        "positions=" + positions +
        '}';
  }

}

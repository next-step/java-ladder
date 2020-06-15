package laddergame.model;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderPositions {

  private final List<Position> positions;

  public LadderPositions(List<Position> positions) {
    if (new HashSet<>(positions).size() != positions.size()) {
      throw new IllegalArgumentException("사다리 위치는 중복될 수 없습니다. positions : " + positions);
    }

    this.positions = positions;
  }

  public Position getPositionByIndex(int index) {
    return positions.get(index);
  }

  public Map<Player, String> getMapOf(Players players, String[] results) {
    return IntStream
        .range(0, positions.size())
        .boxed()
        .collect(Collectors
            .toMap(players::getPlayerByIndex, i -> results[positions.get(i).getValue()]));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderPositions that = (LadderPositions) o;
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

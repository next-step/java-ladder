package laddergame.model;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LadderPositions {

  List<Position> positions;

  public LadderPositions(List<Position> positions) {
    if (new HashSet<>(positions).size() != positions.size()) {
      throw new IllegalArgumentException("사다리 위치는 중복될 수 없습니다. positions : " + positions);
    }

    this.positions = positions;
  }

  public Position getPositionByIndex(int index) {
    return positions.get(index);
  }

  public List<Position> getPositions() {
    return Collections.unmodifiableList(positions);
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

package ladder.domain;

import java.util.Objects;
import ladder.domain.generator.RandomValueGenerator;

public class LadderPart {

  private final int index;
  private final Connect connect;

  private LadderPart(int index, Connect connect) {
    this.index = index;
    this.connect = connect;
  }

  public static LadderPart first() {
    return new LadderPart(0, Connect.first(getRandom()));
  }

  public LadderPart last() {
    return new LadderPart(this.index + 1, this.connect.last());
  }

  private static boolean getRandom() {
    return RandomValueGenerator.randomBoolean();
  }

  public static LadderPart of(int index, Connect connect) {
    return new LadderPart(index, connect);
  }

  public int move() {
    return this.connect.move(index);
  }

  public LadderPart generateNext() {
    return new LadderPart(index + 1, connect.generateNext(getRandom()));
  }

  public Connect getConnect() {
    return connect;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LadderPart)) {
      return false;
    }
    LadderPart that = (LadderPart) o;
    return index == that.index && connect == that.connect;
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, connect);
  }
}

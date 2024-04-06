package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Player> {
  private final List<Player> values;

  public Players(List<Player> values) {
    this.values = values;
  }

  public List<Player> values() {
    return this.values;
  }

  @Override
  public Iterator<Player> iterator() {
    return new PlayerIterator();
  }

  private class PlayerIterator implements Iterator<Player> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < values.size();
    }

    @Override
    public Player next() {
      if (hasNext()) {
        return values.get(cursor++);
      }
      throw new IllegalStateException("더 이상 불러올 요소가 없습니다.");
    }
  }
}

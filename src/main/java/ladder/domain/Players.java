package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Player> {
  private final List<Player> players;

  public Players(List<Player> players) {
    this.players = players;
  }

  public int size() {
    return players.size();
  }

  public String nameAt(final int index) {
    return this.players.get(index).name();
  }

  @Override
  public Iterator<Player> iterator() {
    return new PlayerIterator();
  }

  private class PlayerIterator implements Iterator<Player> {
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor < players.size();
    }

    @Override
    public Player next() {
      if (hasNext()) {
        return players.get(cursor++);
      }
      throw new IllegalStateException("더 이상 불러올 요소가 없습니다.");
    }
  }
}

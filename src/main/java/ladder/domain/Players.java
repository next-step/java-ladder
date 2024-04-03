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

  public Player at(final int index) {
    return this.players.get(index);
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
      return players.get(cursor++);
    }
  }
}

package ladder.domain;

public class LadderResult {

  private final Ladder ladder;
  private final Results results;

  public LadderResult(Ladder ladder, Results results) {
    this.ladder = ladder;
    this.results = results;
  }

  public void result(Players players) {
    int index = 0;
    for (Name name : players.names()) {
      results.put(name, findResultIndex(index++));
    }
  }

  private int findResultIndex(int start) {
    int index = start;
    for (Line line : ladder.lines()) {
      index = line.move(index);
    }
    return index;
  }
}

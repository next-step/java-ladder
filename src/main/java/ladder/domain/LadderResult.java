package ladder.domain;

public class LadderResult {

  private final Ladder ladder;
  private final Results results;

  public LadderResult(Ladder ladder, Results results) {
    this.ladder = ladder;
    this.results = results;
  }

  public void result(Players players) {
    int countOfPerson = players.names().size();
    for (int i = 0; i < countOfPerson; i++) {
      results.put(players.player(i), position(i));
    }
  }

  private int position(int start) {
    int index = start;
    for (Line line : ladder.lines()) {
      index += line.move(index);
    }
    return index;
  }
}

package nextstep.ladder.biz;

public class LadderAnalysis {

  private Ladder ladder;

  public LadderAnalysis(Ladder ladder) {
    this.ladder = ladder;
  }

  public int stat(int index) {
    for (Line line : ladder.getLines()) {
      for (Point point : line.getLine()) {

      }
    }
    return index;
  }

  public void stat(Chessmen chessmen) {
    for (Line line : ladder.getLines()) {
      LineAnalysis.stat(line, chessmen);
    }
  }
}

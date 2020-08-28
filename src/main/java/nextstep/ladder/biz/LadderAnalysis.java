package nextstep.ladder.biz;

public class LadderAnalysis {

  private Ladder ladder;

  public LadderAnalysis(Ladder ladder) {
    this.ladder = ladder;
  }

  public void stat(Chessmen chessmen) {
    for (Line line : ladder.getLines()) {
      LineAnalysis.stat(line.selectableLine(chessmen), chessmen);
    }
  }
}

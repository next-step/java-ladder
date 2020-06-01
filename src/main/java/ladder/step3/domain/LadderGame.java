package ladder.step3.domain;

public class LadderGame {

  private final Ladder ladder;

  private LadderGame (Ladder ladder) {
    this.ladder = ladder;
  }

  public static LadderGame of (Ladder ladder) {
    return new LadderGame(ladder);
  }
}

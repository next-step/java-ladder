package ladder.domain;

public class MatchOfPrize {

  private final Prizes prizes;

  public MatchOfPrize(String[] prizes) {
    this.prizes = new Prizes(prizes);
  }
}

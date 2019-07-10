package ladder.model;

public class LadderGame {

  private final Ladder ladder;
  private final Players players;
  private final Rewards rewards;

  public LadderGame(Ladder ladder, Players players, Rewards rewards) {
    this.ladder = ladder;
    this.players = players;
    this.rewards = rewards;
  }

  public Result start() {
    this.ladder.ride(players);
    this.award();

    return makeResult();
  }


  int award() {
    return (int) this.rewards.getRewards().stream()
            .map(players::takeReward)
            .count();
  }

  Result makeResult() {
    return this.players.makeResult(new Result());
  }
}

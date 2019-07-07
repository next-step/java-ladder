package ladder.model;

public class LadderGame {

  public static void start(Ladder ladder, Players players) {
    ladder.ride(players);
  }

  public static Result makeResult(Players players, Rewards rewards) {
    Result result = new Result();
    players.takeRewards(rewards, result);

    return result;
  }
}

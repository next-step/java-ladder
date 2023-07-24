package nextstep.ladder;


import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderPoints;
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.domain.PlayerNames;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.RandomLadderBarStatusDecider;
import nextstep.ladder.domain.dto.Rewards;
import nextstep.ladder.presentation.InputView;
import nextstep.ladder.presentation.ResultView;

public class Main {
  public static void main(String[] args) {
    PlayerNames playerNames = InputView.getPlayerNames();
    Rewards rewards = InputView.getRewards();

    int ladderLength = InputView.getLadderLength();
    LadderPoints ladderPoints = LadderPoints.of(
        ladderLength,
        playerNames.size(),
        new RandomLadderBarStatusDecider());

    Ladder ladder = new Ladder(ladderPoints);
    Players players = ladder.play(playerNames, rewards.toMap());

    ResultView.printResult(players, ladderPoints, rewards);
    printGameResult(players);
  }

  private static void printGameResult(Players players) {
    PlayerName playerName = InputView.getPlayerName();

    if (!playerName.isAll()) {
      ResultView.printAPlayerResult(players.getPlayer(playerName));
      printGameResult(players);
      return;
    }

    ResultView.printAllPlayersResult(players);
  }
}

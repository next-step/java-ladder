package nextstep.ladder;


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.domain.PlayerNames;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.RandomLadderBarStatusDecider;
import nextstep.ladder.domain.Referee;
import nextstep.ladder.domain.dto.GameResults;
import nextstep.ladder.presentation.InputView;
import nextstep.ladder.presentation.ResultView;

public class Main {
  public static void main(String[] args) {
    PlayerNames playerNames = InputView.getPlayerNames();
    GameResults inputGameResults = InputView.getGameResults();

    int ladderLength = InputView.getLadderLength();
    Ladder ladder = LadderFactory.createLadder(ladderLength, playerNames.size(), new RandomLadderBarStatusDecider());
    GameResults evaluatedGameResults = Referee.getResults(ladder, playerNames, inputGameResults);

    Players players = new Players(toPlayerMap(playerNames, evaluatedGameResults));

    ResultView.printResult(players, ladder, inputGameResults);

    while(true) {
      PlayerName playerName = InputView.printTargetResult();
      if (playerName.isAll()) {
        ResultView.printTargetsResult(players);
        continue;
      }

      ResultView.printTargetResult(players.getPlayer(playerName));
    }
  }

  private static Map<PlayerName, Player> toPlayerMap(PlayerNames playerNames, GameResults gameResults) {
    return IntStream.range(0, playerNames.getPlayerNames().size())
        .boxed()
        .collect(Collectors.toMap(
            i -> playerNames.getPlayerNames().get(i),
            i -> new Player(playerNames.getPlayerNames().get(i), i, gameResults.getResult(i))
        ));
  }
}

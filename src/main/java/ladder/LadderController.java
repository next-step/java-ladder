package ladder;

import view.LadderInputView;
import view.LadderOutputView;

public class LadderController {

  private final LadderInputView inputView;
  private final LadderOutputView outputView;

  public LadderController() {
    inputView = new LadderInputView();
    outputView = new LadderOutputView();
  }

  public void proceed() {
    Players players = inputView.inputPlayers();
    Prizes prizes = inputView.inputResults(players);
    Height height = inputView.inputHeight();

    Ladder ladder = Ladder.from(players, height);

    outputView.printLadder(players, ladder, prizes);
    LadderResults ladderResults = execute(ladder, players, prizes);
    selectResult(ladderResults, players);
  }

  private LadderResults execute(Ladder ladder, Players players, Prizes prizes) {
    LadderResults ladderResults = LadderResults.init(players);
    for (Name player : players.playerNames()) {
      LineIndex index = LineIndex.init(players, player);
      ladderResults.put(player, ladder.findResult(prizes, index));
    }
    return ladderResults;
  }

  private void selectResult(LadderResults ladderResults, Players players) {
    boolean keepGoing;
    do {
      keepGoing = printResult(ladderResults, players);
    } while (keepGoing);
  }

  private boolean printResult(LadderResults ladderResults, Players players) {
    Name player = inputView.inputName();
    if (Name.EXIT.equals(player)) {
      return false;
    }

    if (Name.ALL.equals(player)) {
      outputView.printResultAll(ladderResults);
      return true;
    }

    if (!players.has(player)) {
      outputView.printWrongName();
      return true;
    }

    outputView.printResult(ladderResults.prizeOf(player));
    return true;
  }
}

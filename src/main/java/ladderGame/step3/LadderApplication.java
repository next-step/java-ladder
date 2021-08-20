package ladderGame.step3;

import ladderGame.step3.model.Ladder;
import ladderGame.step3.model.Players;
import ladderGame.step3.view.InputView;
import ladderGame.step3.view.ResultView;

public class LadderApplication {

  public static void main(String[] args) {
    String usersName = InputView.inputUserNames();
    int ladderHeight = InputView.inputLadderHeight();

    Players players = new Players(Players.of(usersName));
    Ladder ladder = new Ladder(Ladder.of(ladderHeight, players.count()));

    ResultView.printUsersName(players.playersName());
    ResultView.printLadder(ladder);
  }
}
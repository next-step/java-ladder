package ladder;

import ladder.model.LadderGame;
import ladder.model.LadderGameInfo;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

  public static void main(String[] args) {
    try {

      String participants = InputView.inputParticipants();
      String results = InputView.inputResults();
      LadderGameInfo ladderGameInfo = new LadderGameInfo(participants, results);
      int ladderHeight = InputView.inputLadderHeight();

      LadderGame ladderGame = new LadderGame(ladderGameInfo, ladderHeight);

      ResultView.printLadderGameResult(ladderGame);

    } catch (NumberFormatException e) {
      System.err.println("숫자값으로 입력해주세요.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

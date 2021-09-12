package ladder;

import ladder.model.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

  public static void main(String[] args) {
    try {

      String participantNames = InputView.inputParticipantNames();
      int ladderHeight = InputView.inputLadderHeight();

      LadderGame ladderGame = new LadderGame(participantNames, ladderHeight);

      ResultView.printResult(ladderGame);

    } catch (NumberFormatException e) {
      System.err.println("숫자값으로 입력해주세요.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

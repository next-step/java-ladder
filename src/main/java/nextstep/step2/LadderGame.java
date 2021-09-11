package nextstep.step2;

import java.util.List;
import nextstep.step2.domain.GameParticipants;
import nextstep.step2.domain.LadderGameEngine;
import nextstep.step2.domain.LadderGameResult;
import nextstep.step2.domain.Ladders;
import nextstep.step2.domain.Line;
import nextstep.step2.view.InputView;
import nextstep.step2.view.ResertView;

public class LadderGame {

  private static final String PRINT_ALL_PARTICIPANTS_KEY = "all";

  public static void main(String[] args) {

    InputView inputView = new InputView();
    String participants = inputView.getParticipants();
    String ladderGameResultStr = inputView.getLadderGameResult();
    int ladderHeight = inputView.getLadderHeigh();

    GameParticipants gameParticipants = new GameParticipants(participants);

    Ladders ladders = new Ladders(ladderHeight);
    List<Line> lines = ladders.create(gameParticipants);

    LadderGameEngine ladderGameEngine = new LadderGameEngine(gameParticipants, lines,
        ladderGameResultStr);
    LadderGameResult ladderGameResult = ladderGameEngine.execute();

    ResertView resertView = new ResertView();
    resertView.printLines(gameParticipants, lines, ladderGameEngine, ladderGameResult);

    printLadderGameResult(inputView, resertView, gameParticipants, ladderGameResult);
  }

  private static void printLadderGameResult(InputView inputView, ResertView resertView,
      GameParticipants gameParticipants, LadderGameResult ladderGameResult) {

    String participantStr;
    do {
      participantStr = inputView.getLadderGameResultParticipant();
      GameParticipants gameParticipantsResult = gameParticipants
          .getGameParticipants(participantStr);
      resertView.printLadderGameResult(ladderGameResult, gameParticipantsResult);
    } while (!participantStr.equals(PRINT_ALL_PARTICIPANTS_KEY));
  }
}

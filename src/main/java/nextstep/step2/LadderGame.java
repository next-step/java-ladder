package nextstep.step2;

import java.util.List;
import nextstep.step2.domain.GameParticipants;
import nextstep.step2.domain.Ladders;
import nextstep.step2.domain.Line;
import nextstep.step2.view.InputView;
import nextstep.step2.view.ResertView;

public class LadderGame {

  public static GameParticipants join(String participants) {
    return new GameParticipants(participants);
  }


  public static void main(String[] args) {

    InputView inputView = new InputView();
    String participants = inputView.getParticipants();
    int ladderHeight = inputView.getLadderHeigh();

    GameParticipants gameParticipants = LadderGame.join(participants);

    Ladders ladders = new Ladders(ladderHeight);
    List<Line> lines = ladders.create(gameParticipants);

    ResertView resertView = new ResertView();
    resertView.printLines(gameParticipants, lines);
  }
}

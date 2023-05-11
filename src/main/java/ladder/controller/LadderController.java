package ladder.controller;

import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.Ladders;
import ladder.domain.Participants;
import ladder.domain.RandomPointGenerationStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

  public static void main (String[] args) {
    Participants participants = InputView.scanPlayerNames();
    Height height = InputView.scanLadderHeight();

    LadderGame ladderGame = new LadderGame(height, participants);
    Ladders ladders = ladderGame.createLadder(new RandomPointGenerationStrategy());

    OutputView.printParticipantsNames(participants);
    OutputView.printLadder(ladders);
  }

}

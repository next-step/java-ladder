package ladder.controller;

import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.Ladders;
import ladder.domain.Participants;
import ladder.domain.RandomPointGenerationStrategy;
import ladder.view.input.InputHeightView;
import ladder.view.input.InputNamesView;
import ladder.view.output.OutputLaddersView;
import ladder.view.output.OutputNamesView;
import ladder.view.output.OutputView;

public class LadderController {

  public static void main (String[] args) {
    Participants participants = InputNamesView.scanPlayerNames();
    Height height = InputHeightView.scanLadderHeight();

    LadderGame ladderGame = new LadderGame(height, participants);
    Ladders ladders = ladderGame.createLadder(new RandomPointGenerationStrategy());

    OutputNamesView.printParticipantsNames(participants);
    OutputLaddersView.printLadder(ladders);
  }

}

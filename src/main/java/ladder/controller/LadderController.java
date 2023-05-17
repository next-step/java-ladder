package ladder.controller;

import java.util.Map;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.LadderSizeInfo;
import ladder.domain.ladder.MatchResults;
import ladder.domain.participant.Participant;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.participant.Participants;
import ladder.domain.strategy.RandomPointGenerationStrategy;
import ladder.view.input.InputHeightView;
import ladder.view.input.InputLadderResultView;
import ladder.view.input.InputNamesView;
import ladder.view.output.OutputLaddersResultView;
import ladder.view.output.OutputLaddersView;
import ladder.view.output.OutputNamesView;
import ladder.view.output.OutputPrizeResultView;

public class LadderController {

  public static void main (String[] args) {
    Participants participants = InputNamesView.scanPlayerNames();

    Prizes prizes = InputLadderResultView.scanPrizes(participants.size());

    Height height = InputHeightView.scanLadderHeight();

    Ladder ladder = Ladder.createLadder(height, participants, new RandomPointGenerationStrategy());

    OutputNamesView.printParticipantsNames(participants);
    OutputLaddersView.printLadder(ladder);
    OutputLaddersResultView.printPrizes(prizes);

    LadderGame ladderGame = new LadderGame(ladder, participants);
    MatchResults results = ladderGame.play(prizes);

    while(true) {
      Participant participant = InputNamesView.scanPlayerName(participants);

      if (participant.isAll()) {
        Map<Participant, Prize> allResults = results.getAllResults();
        OutputPrizeResultView.printAllResults(allResults);
        break;
      }

      Prize prize = results.getResult(participant);
      OutputPrizeResultView.printResult(prize);
    }

  }

}

package ladder;

import ladder.domain.*;
import ladder.view.GameResult;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String args[]) {
        List<String> participantList = InputView.getParticipant();
        List<String> resultList = InputView.getResults();
        int countOfPerson = participantList.size();

        int ladderMaxLength = InputView.getLadderMaxLength();

        ResultView.printLadderResultComment();

        Participant participant = Participant.of(participantList);
        ResultView.printParticipant(participant);

        NextStrategy nextStrategy = new RandomNextStrategy();
        Ladder ladder = Ladder.of(ladderMaxLength, countOfPerson, nextStrategy);
        ResultView.drawLadder(ladder);

        Results results = Results.of(resultList);
        ResultView.printInitResults(results);

        Positions positions = Positions.of(participant, ladder);

        Results finalResults = results.getFinalResults(positions);

        GameResult gameResult = GameResult.of(participant, finalResults);

        String person = InputView.getPersonForResult();

        ResultView.printResult(person, gameResult);
    }
}

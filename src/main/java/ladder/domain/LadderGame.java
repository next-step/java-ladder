package ladder.domain;

import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        LadderGameContext gameContext = createGameContext();
        ResultMapping resultMapping = new ResultMapping(gameContext);
        resultView.printLadder(gameContext);
        findResults(resultMapping);
    }

    private LadderGameContext createGameContext() {
        List<String> names = inputView.readParticipantNames();
        List<String> resultInputs = inputView.readLadderResults();

        Participants participants = new Participants(names);
        Results results = new Results(resultInputs);
        results.validateSize(participants.size());

        int height = inputView.readLadderHeight();
        int width = participants.size() - 1;
        LadderSize ladderSize = new LadderSize(width, height);
        Ladder ladder = Ladder.generate(ladderSize, new RandomConnection());

        return new LadderGameContext(participants, ladder, results);
    }

    private void findResults(ResultMapping resultMapping) {
        findSingleResult(resultMapping);
        findFinalResults(resultMapping);
    }

    private void findSingleResult(ResultMapping resultMapping) {
        while (true) {
            String name = inputView.readNameToFindResult();
            if (name.equalsIgnoreCase("all")) {
                break;
            }
            String result = resultMapping.findResult(name);
            resultView.printResult(name, result);
        }
    }

    private void findFinalResults(ResultMapping resultMapping) {
        for (String participantName : resultMapping.allParticipants()) {
            String result = resultMapping.findResult(participantName);
            resultView.printResult(participantName, result);
        }
    }
}

package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.LadderJackpots;
import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.RandomCreationStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String initPerson = InputView.initPerson();
        LadderJackpots ladderJackpots = LadderJackpots.of(InputView.excutionResult(), initPerson);
        ResultView resultView = ResultView.getInstance();


        int maxLadderHeight = InputView.maxLadderHeight();

        LadderNames ladderNames = LadderNames.of(initPerson);

        resultView.printLadderNames(ladderNames);

        List<Lines> linesList = new ArrayList<>();

        for (int i = 0; i < maxLadderHeight; i++) {
            linesList.add(Lines.of(ladderNames.size(), new RandomCreationStrategy()));
        }

        resultView.printLadderLines(linesList);
        resultView.printLadderResults(ladderJackpots);


        String resultName = InputView.resultName();
        if(resultName.equals("all")) {
            for (int i = 0; i < ladderNames.size(); i++) {
                int moveIndex = ((i + 1) * 2) - 1;

                int result = ladderJackpots.result(moveIndex, linesList);

                String ladderResult = ladderJackpots.findJackpot(result);

                resultName = ladderNames.getLadderName(i);

                resultView.printResult(resultName, ladderResult);
            }
        }

        int moveIndex = ((ladderNames.findIndex(resultName) + 1) * 2) - 1;

        int result = ladderJackpots.result(moveIndex, linesList);

        String ladderResult = ladderJackpots.findJackpot(result);

        resultView.printResult(resultName, ladderResult);
    }
}

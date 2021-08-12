package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderJackpots;
import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String initPerson = InputView.initPerson();
        LadderNames ladderNames = LadderNames.of(initPerson);

        LadderJackpots ladderJackpots = LadderJackpots.of(InputView.excutionResult(), ladderNames);
        ResultView resultView = ResultView.getInstance();
        int maxLadderHeight = InputView.maxLadderHeight();




        resultView.printLadderNames(ladderNames);

        Ladder ladder = Ladder.makeLadder(ladderNames.size(), maxLadderHeight);

        resultView.printLadderLines(ladder);
        resultView.printLadderResults(ladderJackpots);

//=================================================
        /*


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

         */
    }
}

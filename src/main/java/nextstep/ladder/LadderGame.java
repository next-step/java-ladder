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

        //결과 볼 사람 입력받기
        String resultName = InputView.resultName();
        int positionNumber = ladderNames.findIndex(resultName);
        int endNumber = ladder.findLocation(positionNumber);

        System.out.println(endNumber);
    }
}

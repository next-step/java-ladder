package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static final String ERR_MSG_RESULTS_NUMBER = "실행 결과의 갯수는 참여하는 사람의 수와 동일해야 합니다.";
    private final Names names;
    private final Ladder ladder;
    private final Results results;

    public LadderController() {
        this.names = null;
        this.ladder = null;
        this.results = null;
    }

    public LadderController(Names names, int height, Results results) {
        this.names = names;
        this.ladder = new Ladder(this.names.getCountOfNames(), height);
        this.results = results;
    }

    public void checkValidationOfResultsNumber(int countOfNames, int countOfResults) {
        if (countOfNames != countOfResults) {
            throw new IllegalArgumentException(ERR_MSG_RESULTS_NUMBER);
        }
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void start() {
        String candidateNames = InputView.inputCandidateNames();
        Names names = Names.of(candidateNames);

        String inputResults = InputView.inputExecutionResult();
        Results results = Results.of(inputResults);
        checkValidationOfResultsNumber(names.getCountOfNames(), results.getResultsSize());

        Integer maxHeight = InputView.inputMaxLadderHeight();
        LadderController controller = new LadderController(names, maxHeight, results);

        ResultView.printResult(controller.getNames(), controller.getLadder());
    }
}

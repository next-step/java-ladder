package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class LadderController {
    public static final String ERR_MSG_RESULTS_NUMBER = "실행 결과의 갯수는 참여하는 사람의 수와 동일해야 합니다.";
    public static final String STR_ALL = "all";
    private final Names names;
    private final Ladder ladder;
    private final Results results;

    public LadderController() {
        this.names = null;
        this.ladder = null;
        this.results = null;
    }

    public LadderController(Names names, Ladder ladder, Results results) {
        this.names = names;
        this.ladder = ladder;
        this.results = results;
    }

    public LadderController(Names names, int height, Results results) {
        this.names = names;
        this.ladder = Ladder.of(this.names.getCountOfNames(), height);
        this.results = results;
    }

    public void checkValidationOfResultsNumber(int countOfNames, int countOfResults) {
        if (countOfNames != countOfResults) {
            throw new IllegalArgumentException(ERR_MSG_RESULTS_NUMBER);
        }
    }

    public Map<Name, String> getExecutionResultAll() {
        Map<Name, String> ladderResult = new HashMap<>();
        for (int i = 0; i < names.getCountOfNames(); i++) {
            int resultIdx = ladder.getLadderEndIdx(i);
            String result = results.getResults().get(resultIdx);
            ladderResult.put(names.getNames().get(i), result);
        }
        return ladderResult;
    }

    public String getExecutionResult(String candidate) {
        Name name = new Name(candidate);
        int idx = this.names.getNames().indexOf(name);
        int resultIdx = ladder.getLadderEndIdx(idx);
        return results.getResults().get(resultIdx);
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

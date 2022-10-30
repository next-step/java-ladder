package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.*;

import static ladder.utils.StringUtils.*;

public class LadderController {


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
        checkValidationOfResultsNumber(names.getCountOfNames(), results.getResultsSize());
    }

    public void checkValidationOfResultsNumber(int countOfNames, int countOfResults) {
        if (countOfNames != countOfResults) {
            throw new IllegalArgumentException(ERR_MSG_RESULTS_NUMBER);
        }
    }

    public Map<Name, String> getExecutionResultAll() {
        Map<Name, String> ladderResult = new LinkedHashMap<>();
        for (int i = 0; i < names.getCountOfNames(); i++) {
            int resultIdx = ladder.getLadderEndIdx(i);
            String result = results.getResults().get(resultIdx);
            ladderResult.put(names.getNames().get(i), result);
        }
        return ladderResult;
    }

    public String getExecutionResult(String candidate) {
        Name candidateName = new Name(candidate);
        int idx = names.getNames().indexOf(candidateName);
        int resultIdx = ladder.getLadderEndIdx(idx);
        return results.getResults().get(resultIdx);
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    private String validateCandidateName(String candidate) {
        if (!isContainedName(candidate)) {
            throw new IllegalArgumentException(ERR_MSG_CANDIDATE_NAME);
        }
        return candidate;
    }

    private boolean isContainedName(String candidate) {
        Optional<Name> candidateName = names.getNames().stream().filter(name -> name.equals(new Name(candidate))).findAny();
        if (!candidateName.isPresent()) {
            return false;
        }
        return true;
    }

    public void start() {
        String candidateNames = InputView.inputCandidateNames();
        Names names = Names.of(candidateNames);

        String inputResults = InputView.inputExecutionResult();
        Results results = Results.of(inputResults);

        Integer maxHeight = InputView.inputMaxLadderHeight();
        LadderController ladderGame = new LadderController(names, maxHeight, results);

        ResultView.printResult(ladderGame.getNames(), ladderGame.getLadder());

        String candidate;
        do {
            candidate = InputView.inputResultCandidateName();
            if (!candidate.equals(STR_ALL)) {
                ladderGame.validateCandidateName(candidate);
                ResultView.printLadderResult(ladderGame.getExecutionResult(candidate));
            }
            if (candidate.equals(STR_ALL)) {
                ResultView.printLadderResultAll(ladderGame.getExecutionResultAll());
            }
        } while(!candidate.equals(STR_ALL));

    }
}

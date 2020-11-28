package nextstep.ladder.view;

import nextstep.ladder.domain.ExecutionResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.ResultCandidates;

public interface ResultView {
    void printLadder(Participants participants, Ladder ladder, ResultCandidates resultCandidates);

    /**
     * @return @Param nameOfWantToCheck를 Results.ALL로 입력받은 경우 true를 리턴한다.
     */
    boolean printResult(ExecutionResults executionResults, Name nameOfWantToCheck);
}

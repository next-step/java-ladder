package nextstep.ladder.view;

import nextstep.ladder.domain.ExecutionResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;

public interface ResultView {
    void printLadder(Participants participants, Ladder ladder, ExecutionResults executionResults);

    /**
     * @return @Param nameOfWantToCheck를 Results.ALL로 입력받은 경우 true를 리턴한다.
     */
    boolean printResult(Results results, Name nameOfWantToCheck);
}

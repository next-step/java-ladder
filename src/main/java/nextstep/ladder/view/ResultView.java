package nextstep.ladder.view;

import nextstep.ladder.domain.ExecutionsResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;

public interface ResultView {
    void printLadder(Participants participants, Ladder ladder, ExecutionsResults executionsResults);

    /**
     * @return @Param nameOfWantToCheck를 Results.ALL로 입력받은 경우 true를 리턴한다.
     */
    boolean printResult(Results results, String nameOfWantToCheck);
}

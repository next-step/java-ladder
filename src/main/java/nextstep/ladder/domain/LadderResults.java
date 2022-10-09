package nextstep.ladder.domain;

import nextstep.ladder.exceptions.ParticipantsAndResultsNumberNotMatchedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    public LadderResults(String[] ladderResults, int numberOfParticipants) {
        if (ladderResults.length != numberOfParticipants) {
            throw new ParticipantsAndResultsNumberNotMatchedException("참가자 수와 사다리 타기 결과의 수는 일치해야 합니다.");
        }
        this.ladderResults = new ArrayList<>();
        for (String ladderResult : ladderResults) {
            this.ladderResults.add(new LadderResult(ladderResult));
        }
    }

    public int numberOfLadderResults() {
        return ladderResults.size();
    }

    public List<LadderResult> value() {
        return Collections.unmodifiableList(ladderResults);
    }

    public LadderResult getLadderResult(int index) {
        return ladderResults.get(index);
    }
}

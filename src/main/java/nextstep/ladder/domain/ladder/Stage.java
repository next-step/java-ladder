package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.executionresult.ExecutionResults;

import java.util.List;

public class Stage {

    private List<Ladder> ladders;
    private ExecutionResults executionResults;

    public Stage(List<Ladder> ladders) {
        removeDuplicateHorizontalLines(ladders);
        this.ladders = ladders;
    }

    private void removeDuplicateHorizontalLines(List<Ladder> ladders) {
        for (int i = 1; i < ladders.size(); i++) {
            Ladder prevLadder = ladders.get(i - 1);
            Ladder ladder = ladders.get(i);
            ladder.removeDuplicatedHorizontalLines(prevLadder);
        }
    }


    public List<Ladder> getLadders() {
        return ladders;
    }
}

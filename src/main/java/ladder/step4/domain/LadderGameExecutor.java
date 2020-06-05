package ladder.step4.domain;

import ladder.step4.domain.strategy.BodyDirectionStrategy;
import ladder.step4.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class LadderGameExecutor {

    private final Ladder ladder;

    private LadderGameExecutor (Ladder ladder) {
        this.ladder = ladder;
    }

    public static Map<Participant, LadderResult> execute (
        Participants participants,
        LadderResults ladderResults,
        Ladder ladder
    ) {
        return new LadderGameExecutor(ladder).execute(participants, ladderResults);
    }

    private Map<Participant, LadderResult> execute (
        Participants participants,
        LadderResults ladderResults
    ) {
        Map<Participant, LadderResult> resultMap = new HashMap<>();
        int width = participants.size() - 1;
        for (int index = 0; index <= width; index++) {
            resultMap.put(
                participants.get(index),
                ladderResults.get(getResultIndex(index))
            );
        }
        return resultMap;
    }

    private int getResultIndex (int index) {
        return ladder.stream()
                     .reduce(index,
                         (x, ladderLine) -> ladderLine.move(x),
                         (x, ladderLine) -> x);
    }

    public static void main(String[] args) {
        final Participants participants = Participants.of("aa,bb,cc,dd");
        final LadderResults ladderResults = LadderResults.of("1,2,3,4", participants);
        final LadderHeight ladderHeight = LadderHeight.valueOf(3);
        final Ladder ladder = Ladder.of(participants, ladderHeight, BodyDirectionStrategy.getInstance());
        ResultView.getInstance().viewLadder(ladder, participants, ladderResults);
        final LadderGame ladderGame = LadderGame.of(
            LadderGameExecutor.execute(participants, ladderResults, ladder)
        );
        ResultView.getInstance().viewResult(ladderGame, participants, "all");
    }
}

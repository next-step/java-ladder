package ladder.view;

import ladder.domain.Bridge;
import ladder.domain.LadderResult;

import java.util.List;

public class ResultView {

    public static void printLadderResult(List<Bridge> ladder, LadderResult ladderResult) {
        System.out.println("\n사다리 결과\n");

        ladderResult.printParticipantNames();
        ladderResult.printLadder(ladder);
        ladderResult.printOutcomes();
    }

    public static void printOutcomeForParticipant(String outcomeForParticipant) {
        System.out.println("\n실행결과");

        System.out.println(outcomeForParticipant);
    }

}

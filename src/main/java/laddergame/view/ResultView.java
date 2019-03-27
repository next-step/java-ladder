
package laddergame.view;

import laddergame.domain.LadderLines;
import laddergame.domain.Participants;
import laddergame.domain.Result;

public class ResultView {
    public static void showResult(Result result) {
        System.out.println("실행결과");
        showParticipants(result.getParticipants());
        showLadderLines(result.getLadderLines());
    }

    public static void showParticipants(Participants participants) {
        System.out.println(participants.toResultString());
    }

    public static void showLadderLines(LadderLines ladderLines) {
        System.out.println(ladderLines);
    }
}

package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

public class ResultView {
    private ResultView() {}

    public static void printLadder(Participants participants, Ladder ladder) {
        System.out.println("실행결과\n");
        System.out.println(participants.tellParticipants());

        for(Line line : ladder.getLadder()){
            System.out.println(line.drawLadderLine());
        }
    }
}

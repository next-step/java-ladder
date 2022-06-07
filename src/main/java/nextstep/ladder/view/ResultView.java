package nextstep.ladder.view;

import nextstep.ladder.domain.LadderInfo;
import nextstep.ladder.domain.Participants;

public class ResultView {

    public void printResult(LadderInfo ladderInfo, Participants participants) {
        System.out.println("실행결과\n");

        printParticipants(participants);

        for (int i = 0; i < ladderInfo.lines().height(); i++) {
            System.out.print("    |");
            for (int j = 0; j < ladderInfo.lines().numberOfParticipants() - 1; j++) {
                System.out.print((ladderInfo.lines(i, j) ? "-----|" : "     |"));
            }
            System.out.println();
        }
    }

    private void printParticipants(Participants participants) {
        for(int i = 0; i < participants.numberOfParticipants(); i++) {
            System.out.printf("%5s ", participants.value().get(i).name());
        }
        System.out.println();
    }
}

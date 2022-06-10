package nextstep.ladder.view;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

public class ResultView {

    public void printResult(Lines lines, Participants participants) {
        System.out.println("실행결과\n");

        printParticipants(participants);
        System.out.println(lines.toLadderLines());
    }

    private void printParticipants(Participants participants) {
        for(int i = 0; i < participants.numberOfParticipants(); i++) {
            System.out.printf("%5s ", participants.value().get(i).name());
        }
        System.out.println();
    }
}

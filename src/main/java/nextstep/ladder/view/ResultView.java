package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;

public class ResultView {

    public void printResult(LadderGame ladderGame) {
        System.out.println("실행결과\n");

        printParticipants(ladderGame.participants());
        System.out.println(ladderGame.view());
    }

    private void printParticipants(Participants participants) {
        for(int i = 0; i < participants.numberOfParticipants(); i++) {
            System.out.printf("%5s ", participants.value().get(i).name());
        }
        System.out.println();
    }
}

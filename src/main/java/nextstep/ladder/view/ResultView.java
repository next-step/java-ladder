package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;

public class ResultView {

    public void printResult(LadderGame ladderGame) {
        System.out.println("실행결과\n");

        printParticipants(ladderGame.participants());
        System.out.print(ladderGame.view());
        printLadderResults(ladderGame.results());
    }

    private void printParticipants(Participants participants) {
        for(int i = 0; i < participants.numberOfParticipants(); i++) {
            System.out.printf("%5s ", participants.value().get(i).name());
        }
        System.out.println();
    }

    private void printLadderResults(Results results) {
        for(int i = 0; i < results.numberOfResults(); i++) {
            System.out.printf("%5s ", results.value().get(i).name());
        }
        System.out.println();
    }
}

package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.LadderResults;

public class ResultView {

    public void printResult(LadderGame ladderGame) {
        System.out.print("실행결과\n");

        printParticipants(ladderGame.participants());
        System.out.print(ladderGame.view());
        printLadderResults(ladderGame.ladderResults());
    }

    private void printParticipants(Participants participants) {
        for(int i = 0; i < participants.numberOfParticipants(); i++) {
            System.out.printf("%5s ", participants.value().get(i).name());
        }
        System.out.println();
    }

    private void printLadderResults(LadderResults ladderResults) {
        for(int i = 0; i < ladderResults.numberOfLadderResults(); i++) {
            System.out.printf("%5s ", ladderResults.value().get(i).name());
        }
        System.out.println();
    }

    public void printResultOfParticipant(String name, String result) {
        System.out.println(name + " : " + result);
    }
}

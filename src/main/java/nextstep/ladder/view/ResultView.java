package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.LadderResults;

import java.util.Objects;

public class ResultView {

    private static final String VIEW_ALL = "all";

    public void printLadderGame(LadderGame ladderGame) {
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

    public void printResultByName(LadderGame ladderGame, String name) {
        if (Objects.equals(name, VIEW_ALL)) {
            printAllResult(ladderGame);
            return ;
        }

        printResultOfParticipant(name, ladderGame.resultOfParticipant(name));
    }

    private void printAllResult(LadderGame ladderGame) {
        for (Participant participant : ladderGame.participants().value()) {
            String name = participant.name();
            printResultOfParticipant(name, ladderGame.resultOfParticipant(name));
        }
    }
}

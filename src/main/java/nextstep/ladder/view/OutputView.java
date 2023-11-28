package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participators;

public class OutputView {

    public void printResult(Participators participators, Ladder ladder) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        printParticipators(participators);
        printLadder(ladder);
    }

    private void printParticipators(Participators participators) {
        System.out.println(participators);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(System.out::println);
    }
}

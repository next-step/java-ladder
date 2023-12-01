package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Participators;

public class OutputView {

    public void printLadderStatus(Participators participators, Ladder ladder, LadderResults ladderResults) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        printParticipators(participators);
        printLadder(ladder);
        System.out.println(ladderResults);
    }

    public void printResult(String result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result);
    }

    private void printParticipators(Participators participators) {
        System.out.println(participators);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(System.out::println);
    }
}
